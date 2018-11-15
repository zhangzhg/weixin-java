package com.hsm.pay.common.model;

import java.util.List;

public class PageResult<T> {
    private int pageSize;
    private long total;
    private int currentPage;
    private List<T> data;

    public PageResult(List<T> data, long total, int size, int page) {
        this.data = data;
        this.pageSize = size;
        this.total = total;
        this.currentPage = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
