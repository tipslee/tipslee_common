package com.jd.innovation.common.db;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页类
 * @author liqiang
 */
public class Pagination {

    private int pageSize = 20;

    private int totalCount;

    private int currentPage;

    private List data;

    public Pagination() {
    }

    public Pagination(int currentPage) {
        this.currentPage = currentPage;
    }

    public Pagination(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    /**
     * 获取开始索引
     *
     * @return
     */
    public int getStartIndex() {
        return (getCurrentPage() - 1) * this.pageSize;
    }

    /**
     * 获取结束索引
     *
     * @return
     */
    public int getEndIndex() {
        return this.pageSize;
    }

    /**
     * 是否第一页
     *
     * @return
     */
    public boolean isFirstPage() {
        return getCurrentPage() <= 1;
    }

    /**
     * 是否末页
     *
     * @return
     */
    public boolean isLastPage() {
        return getCurrentPage() >= getPageCount();
    }

    /**
     * 获取下一页页码
     *
     * @return
     */
    public int getNextPage() {
        if (isLastPage()) {
            return getCurrentPage();
        }
        return getCurrentPage() + 1;
    }

    /**
     * 获取上一页页码
     *
     * @return
     */
    public int getPreviousPage() {
        if (isFirstPage()) {
            return 1;
        }
        return getCurrentPage() - 1;
    }

    /**
     * 获取当前页页码
     *
     * @return
     */
    public int getCurrentPage() {
        if (currentPage == 0) {
            currentPage = 1;
        }
        return currentPage;
    }

    /**
     * 取得总页数
     *
     * @return
     */
    public int getPageCount() {
        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }

    /**
     * 取总记录数.
     *
     * @return
     */
    public int getTotalCount() {
        return this.totalCount;
    }

    /**
     * 设置当前页
     *
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取每页数据容量.
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 该页是否有下一页.
     *
     * @return
     */
    public boolean hasNextPage() {
        return getCurrentPage() < getPageCount();
    }

    /**
     * 该页是否有上一页.
     *
     * @return
     */
    public boolean hasPreviousPage() {
        return getCurrentPage() > 1;
    }

    /**
     * 获取数据集
     *
     * @return
     */
    public <E> List<E> getResult() {
        if (data == null) {
            data = new ArrayList();
        }
        return data;
    }

    /**
     * 设置数据集
     *
     * @param data
     */
    public <E> void setResult(List<E> data) {
        this.data = data;
    }

    /**
     * 设置总记录条数
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}