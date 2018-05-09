package com.jd.innovation.common.db.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Dao层
 * @author liqiang
 * 2016/7/26
 */
public interface BaseDao<T> {

    /**
     * 获取MyBatis命名空间
     */
    String getNameSpace(String statement);

    /**
     * 添加对象
     * @param t 插入对象
     * @return 对象主键id
     */
    int insertEntry(T t);

    /**
     * 批量添加对象
     * @param list 插入对象List
     */
    void batchInsert(List<T> list);

    /**
     * 删除对象，根据条件
     * @param t 单个对象
     * @return 删除个数
     */
    int deleteByWhere(T t);

    /**
     * 删除对象,主键
     * @param key 主键
     * @return 删除个数
     */
    int deleteById(Serializable key);

    /**
     * 更新对象,条件主键
     * @param t 条件
     * @return 个数
     */
    int updateByWhere(T t);

    /**
     * 查询对象,条件主键
     * @param key 主键
     * @return 对象
     */
    T selectById(Serializable key);

    /**
     * 查询对象,只要不为NULL与空则为条件
     * @param t 查询条件
     * @return 查询结果
     */
    List<T> selectByWhere(T t);

    /**
     * 查询对象总数
     * @param t 查询条件
     * @return 个数
     */
    int selectCountByWhere(T t);

    /**
     * 查询对象列表
     * @param t 查询条件
     * @return 结果
     */
    List<T> selectPageByWhere(T t);


}
