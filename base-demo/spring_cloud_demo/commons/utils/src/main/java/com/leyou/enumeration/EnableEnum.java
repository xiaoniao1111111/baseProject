package com.leyou.enumeration;

/**
 * 权限拦截枚举  启用 禁用
 *
 * @Author: WangXinWei
 * @Date: 2020/1/7 9:32
 * @Version 1.0
 */
public enum EnableEnum {
    ENABLE(1, "启用"),
    DISABLE(0, "禁用");
    private Integer type;
    private String desc;

    EnableEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}

