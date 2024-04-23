package com.spring.srping.pojo;

import lombok.Data;

/**
 * @Author WangXinWei
 * @Date 2022/3/10 16:09
 * @Version 1.0
 */
@Data
public class Book {
    private Integer id;
    private String name;
    private Double price;

    public Book() {
    }

    public Book(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
