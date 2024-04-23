package com.study.structural_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类(该类设计为单例)
 *
 * @Author: WangXinWei
 * @Date: 2024-02-01-16:37
 * @Version 1.0
 */
public class BoxFactory {

    private static BoxFactory boxFactory = new BoxFactory();

    private Map<String, AbstractBox> map;

    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    /**
     * 提供一个方法获取该工厂对象
     *
     * @return
     */
    public static BoxFactory getInstance() {
        return boxFactory;
    }


    /**
     * 根据名称获取图形对象
     *
     * @param shapeName
     * @return
     */
    public AbstractBox getShape(String shapeName) {
        return map.get(shapeName);
    }
}
