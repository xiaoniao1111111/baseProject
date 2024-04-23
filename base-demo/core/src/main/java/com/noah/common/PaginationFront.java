package com.noah.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * 分页对象
 *
 * @Author: WangXinWei
 * @Date: 2019/5/31 9:15
 * @Version 1.0
 */

public class PaginationFront implements Serializable {
    private static final long serialVersionUID = 2575942750484447743L;
    int currentPage;
    int pageSize;

    public PaginationFront() {
    }

    public PaginationFront(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PaginationFront{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
            PaginationFront that = (PaginationFront) o;
            return currentPage == that.currentPage &&
                    pageSize == that.pageSize;
        }



    @Override
    public int hashCode() {
        return Objects.hash(currentPage, pageSize);
    }

}
