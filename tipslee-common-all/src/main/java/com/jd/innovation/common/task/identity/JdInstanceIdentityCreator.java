package com.jd.innovation.common.task.identity;


import org.apache.commons.lang.StringUtils;

/**
 * 京东应用实例身份生成器
 * @author liqiang
 * 2016/7/27
 */
public class JdInstanceIdentityCreator implements IdentityCreator {

    //默认唯一Key
    private String defaultUniqueKey;

    @Override
    public String uniqueIdentity() {
        String uniqueKey = null;
        String appId = System.getProperty("deploy.app.id");
        String instanceId = System.getProperty("deploy.instance.id");
        if (StringUtils.isNotEmpty(appId) && StringUtils.isNotEmpty(instanceId)) {
            uniqueKey = appId + "#" + instanceId;
            uniqueKey = StringUtils.join(new String[]{appId, instanceId}, "#");
        }
        if (uniqueKey == null && defaultUniqueKey != null) {
            uniqueKey = defaultUniqueKey;
        }
        return uniqueKey;
    }

    public void setDefaultUniqueKey(String defaultUniqueKey) {
        this.defaultUniqueKey = defaultUniqueKey;
    }
}
