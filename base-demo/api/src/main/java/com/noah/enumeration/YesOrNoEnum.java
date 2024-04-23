package com.noah.enumeration;

/**
 * @Author: WangXinWei
 * @Date: 2020/1/7 9:16
 * @Version 1.0
 */
public enum YesOrNoEnum {
    YES(1, "是"),
    NO(2, "否");
    private Integer type;
    private String desc;

    YesOrNoEnum(Integer type, String desc) {
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
