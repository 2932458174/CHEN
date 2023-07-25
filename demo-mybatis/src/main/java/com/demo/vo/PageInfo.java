package com.demo.vo;

import java.util.List;

public class PageInfo<T> {
    private int currentPage;
    //当前页
    private int pageCurrent;
    //支行数
    private int pageSize;
    //总条数
    private int sumCounts;
    //总页数
    private int sumPages;
    //数据结果集
    private List<T> dateList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSumCounts() {
        return sumCounts;
    }

    public void setSumCounts(int sunCounts) {
        this.sumCounts = sunCounts;
    }

    public int getSumPages() {
        return sumPages;
    }

    public void setSumPages(int sumPages) {
        this.sumPages = sumPages;
    }
    public List<T> getDateList() {
        return dateList;
    }

    public void setDateList(List<T> dateList) {
        this.dateList = dateList;
    }
}
