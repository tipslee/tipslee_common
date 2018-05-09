package com.jd.innovation.common.test.dao;


import com.jd.innovation.common.db.dao.BaseDaoImpl;
import com.jd.innovation.common.test.domain.SurveyDomain;

/**
 * Created by liqiang
 * 2016/7/20
 */
public class SurveyDaoImpl extends BaseDaoImpl<SurveyDomain> implements SurveyDao {

    @Override
    public String getNameSpace(String statement) {
        return "survey." + statement;
    }
}
