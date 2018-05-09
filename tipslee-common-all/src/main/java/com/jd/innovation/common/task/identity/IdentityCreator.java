package com.jd.innovation.common.task.identity;

/**
 * 身份标志Creator
 * @author liqiang
 * 2016/7/27
 */
public interface IdentityCreator {

    /**
     * 生成唯一身份标志
     * @return
     */
    public String uniqueIdentity();
}
