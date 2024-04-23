package com.noah.common;


import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 * 分页封装的请求体
 *
 * @Author: WangXinWei
 * @Date: 2019/5/31 9:13
 * @Version 1.0
 */
@Component
public class PaginationRequest<T> implements Serializable {
    T data;
    PaginationFront pagination;

    public PaginationRequest() {
        this.pagination = new PaginationFront();
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PaginationFront getPaginationFront() {
        return pagination;
    }

    public void setPaginationFront(PaginationFront paginationFront) {
        this.pagination = paginationFront;
    }

    @Override
    public String toString() {
        return "PaginationRequest{" +
                "data=" + data +
                ", paginationFront=" + pagination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        PaginationRequest<?> that = (PaginationRequest<?>) o;
        return data.equals(that.data) &&
                pagination.equals(that.pagination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, pagination);
    }
}
