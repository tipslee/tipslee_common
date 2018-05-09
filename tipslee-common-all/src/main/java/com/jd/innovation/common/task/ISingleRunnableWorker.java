package com.jd.innovation.common.task;

/**
 * 保证单实例Run，Worker接口
 * @author liqiang
 * 2016/7/27
 */
public interface ISingleRunnableWorker {

    /**
     * 执行任务
     */
    public void doWork();
}
