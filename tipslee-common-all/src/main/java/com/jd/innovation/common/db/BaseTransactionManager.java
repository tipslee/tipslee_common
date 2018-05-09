package com.jd.innovation.common.db;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author hechangrong
 */
public class BaseTransactionManager {
	  
	private PlatformTransactionManager transactionManager;

	public TransactionTemplate getDataSourceTransactionManager() {
	        return new TransactionTemplate(transactionManager);
	    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    
}
