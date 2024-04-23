package com.study.structural_pattern.decorator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 快餐类(抽象构件角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-01-28-11:21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class FastFood {
    /**
     * 价格
     */
    private float price;
    /**
     * 描述
     */
    private String desc;


    /**
     *
     * @return
     */
    public abstract float cast();
}
