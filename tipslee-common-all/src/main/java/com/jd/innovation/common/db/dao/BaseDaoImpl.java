package com.jd.innovation.common.db.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Dao层实现
 * @author liqiang
 * 2016/7/26
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected static final String SELECT_PAGE_BY_WHERE = "selectPageByWhere";//分页查询sql id标识 --结果集
    protected static final String SELECT_COUNT_BY_WHERE = "selectCountByWhere";//分页查询sql id标识 --总数
    protected static final String SELECT_BY_WHERE = "selectByWhere";//按条件查询结果为list的sql
    protected static final String SELECT_BY_ID = "selectById";//按主键查询sql id标识
    protected static final String UPDATE_BY_WHERE = "updateByWhere";//按主键更新sql id标识
    protected static final String DELETE_BY_ID = "deleteById";//按key删除sql id标识
    protected static final String DELETE_BY_WHERE = "deleteByWhere";//按条件删除sql
    protected static final String INSERT_ENTRY = "insertEntry";//插入sql id标识
    protected static final String BATCH_INSERT = "batchInsert";//批量插入sql id标识

    public abstract String getNameSpace(String statement);

    @Override
    public int insertEntry(T t) {
        return this.getSqlSession().insert(getNameSpace(INSERT_ENTRY), t);
    }

    @Override
    public void batchInsert(List<T> list) {
        this.getSqlSession().insert(getNameSpace(BATCH_INSERT), list);
    }

    @Override
    public int deleteByWhere(T t) {
        return this.getSqlSession().delete(getNameSpace(DELETE_BY_WHERE), t);
    }

    @Override
    public int deleteById(Serializable key) {
        return this.getSqlSession().delete(getNameSpace(DELETE_BY_ID), key);
    }

    @Override
    public int updateByWhere(T t) {
        return this.getSqlSession().update(getNameSpace(UPDATE_BY_WHERE), t);
    }

    @Override
    public T selectById(Serializable key) {
        return (T) this.getSqlSession().selectOne(getNameSpace(SELECT_BY_ID), key);
    }

    @Override
    public List<T> selectByWhere(T t) {
        return this.getSqlSession().selectList(getNameSpace(SELECT_BY_WHERE), t);
    }

    @Override
    public int selectCountByWhere(T t) {
        return (Integer) this.getSqlSession().selectOne(getNameSpace(SELECT_COUNT_BY_WHERE), t);
    }

    @Override
    public List<T> selectPageByWhere(T t) {
        return this.getSqlSession().selectList(getNameSpace(SELECT_PAGE_BY_WHERE), t);
    }

}
