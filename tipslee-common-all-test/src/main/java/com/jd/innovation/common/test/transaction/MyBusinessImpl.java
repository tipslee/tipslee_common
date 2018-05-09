package com.jd.innovation.common.test.transaction;

import com.jd.innovation.common.db.BaseTransactionManager;
import com.jd.innovation.common.test.dao.SurveyDao;
import com.jd.innovation.common.test.domain.SurveyDomain;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author liqiang
 * 2016/7/27
 */
public class MyBusinessImpl extends BaseTransactionManager implements MyBusiness {

    @Resource
    SurveyDao surveyDao;

    @Override
    public void addSurvey(final SurveyDomain surveyDomain) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    SurveyDomain s1 = new SurveyDomain();
                    s1.setId(1L);
                    s1.setTitle("我le4");
                    surveyDao.updateByWhere(s1);

                    SurveyDomain s2 = new SurveyDomain();
                    s2.setId(13L);
                    s2.setTitle("TestTitle");
                    surveyDao.insertEntry(s2);

                } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }

}
