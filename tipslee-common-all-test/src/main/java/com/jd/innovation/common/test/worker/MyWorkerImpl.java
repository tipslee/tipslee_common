package com.jd.innovation.common.test.worker;

import com.jd.innovation.common.task.ISingleRunnableWorker;

/**
 * TestWorker
 * @author liqiang
 */
public class MyWorkerImpl implements ISingleRunnableWorker {

    @Override
    public void doWork() {
        try {
            System.out.println("-------------MyWorkerImpl----");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
