package com.jd.innovation.common.task.sequence;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 任务序列拦截切面，控制Worker单例执行
 * @author liqiang
 * 2016/7/26
 */
public interface ISequenceAspect {

    /**
     * 争取锁
     * @param jp
     */
    public void lock(ProceedingJoinPoint jp) throws Throwable;

    /**
     * 释放锁
     * @param jp
     * @param e
     */
    public void unlock(JoinPoint jp, Throwable e);

    /**
     * 异常处理，解锁
     * @param jp
     * @param e
     */
    public void doAfterThrowing(JoinPoint jp, Throwable e);
}
