package com.study.structural_pattern.flyweight;

/**
 * L图形类(具体享元角色)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-16:35
 * @Version 1.0
 */
public class LBox extends AbstractBox {
    @Override
    public String getShape() {
        return "L";
    }
}
