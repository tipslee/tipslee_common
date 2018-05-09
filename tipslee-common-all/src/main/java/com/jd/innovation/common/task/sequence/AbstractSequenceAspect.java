package com.jd.innovation.common.task.sequence;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;

/**
 * 任务序列拦截切面抽象类
 * @author liqiang
 * 2016/7/27
 */
public abstract class AbstractSequenceAspect implements ISequenceAspect {

    @Override
    public void doAfterThrowing(JoinPoint jp, Throwable e) {
        unlock(jp, e);
    }

    /**
     * 获取类名和方法名
     * @param jp
     * @return
     */
    protected String getJoinPointName(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String clazzName = jp.getTarget().getClass().getName();
        String clazzAndMethod = StringUtils.join(new String[]{clazzName, methodName}, "#");
        return clazzAndMethod;
    }
}
