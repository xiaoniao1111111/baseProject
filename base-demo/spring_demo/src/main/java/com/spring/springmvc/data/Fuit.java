package com.spring.springmvc.data;

import lombok.Data;

/**
 * @Author WangXinWei
 * @Date 2022/3/12 8:38
 * @Version 1.0
 */
@Data
public class Fuit {
    public Fuit() {
    }

    public Fuit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private Double price;
}
