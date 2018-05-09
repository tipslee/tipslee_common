package com.jd.innovation.common.task.sequence;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jd.innovation.common.task.identity.IdentityCreator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * 基于Redis实现控制
 * TODO 当某实例持有锁，未执行Expire时，如果被缩容，会存在死锁问题
 *
 * @author liqiang
 *         2016/7/26
 */
public class RedisSequenceAspect extends AbstractSequenceAspect {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    private Jedis jedis;
    private IdentityCreator identityCreator;//身份标志生成器
    private int lockTimeOutSeconds = 3600;//锁超时时间 默认为3600秒

    @Override
    public void lock(ProceedingJoinPoint jp) throws Throwable {
        String jpName = getJoinPointName(jp);
        String uniqueKey = identityCreator.uniqueIdentity();
        Long result = jedis.setnx(jpName, uniqueKey);
        boolean isLock = false;
        if (result == 1) {
            isLock = true;
        }
        if (isLock) {
            //获取到锁
            jedis.expire(jpName, lockTimeOutSeconds);
            jp.proceed();
            unlock(jp, null);
        } else {
            //死锁情况：当某台实例获取到锁，执行中，异常终止，并没有unlock
            //没有获取到锁，判断是否为异常退出，导致死锁
            String val = jedis.get(jpName);
            if (val != null && val.equals(uniqueKey)) {
                jp.proceed();
                unlock(jp, null);
            }
        }
    }

    @Override
    public void unlock(JoinPoint jp, Throwable e) {
        String jpName = getJoinPointName(jp);
        jedis.del(jpName);
        if (null != e) {
            logger.error(jp.getTarget().getClass().getName() + "中的"
                    + jp.getSignature().getName() + "方法抛出异常", e);
            if (jp.getArgs() != null && jp.getArgs().length > 0) {
                for (int i = 0; i < jp.getArgs().length; i++) {
                    logger.error("参数：--" + getValueFromArgs(jp.getArgs()[i]));
                }
            }
        }
    }

    private String getValueFromArgs(Object object) {
        if (object == null) return "";
        if (object.getClass().isArray()) {
            return JSONArray.toJSONString(object);
        }
        return JSONObject.toJSONString(object);
    }

    public void setIdentityCreator(IdentityCreator identityCreator) {
        this.identityCreator = identityCreator;
    }

    public void setLockTimeOutSeconds(Integer lockTimeOutSeconds) {
        this.lockTimeOutSeconds = lockTimeOutSeconds;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }
}
