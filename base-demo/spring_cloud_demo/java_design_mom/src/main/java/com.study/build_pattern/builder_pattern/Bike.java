package com.study.build_pattern.builder_pattern;

import lombok.Data;

/**
 * 产品对象
 * @Author: WangXinWei
 * @Date: 2024-01-17-15:49
 * @Version 1.0
 */
@Data
public class Bike {
    /**
     * 车架
     */
    private String frame;
    /**
     * 车座
     */
    private String seat;
}
