package com.chhaya.utils;

public class Pagination {

    private int page;
    private int limit;
    private int offset;
    private int totalRecords;
    private int totalPages;

    public Pagination() {
        page = 1;
        limit = 2;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        if (page == 1)
            return 0;
        else
            return (page -1) * limit;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) totalRecords / (double)limit);
    }

}
