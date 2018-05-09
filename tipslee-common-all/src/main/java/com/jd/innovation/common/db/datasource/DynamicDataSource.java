package com.jd.innovation.common.db.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @author liqiang
 * 2016/7/28
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private String dbInUse;

    protected Object determineCurrentLookupKey() {
        return dbInUse;
    }

    public void setDbInUse(String dbInUse) {
        this.dbInUse = dbInUse;
    }
}
