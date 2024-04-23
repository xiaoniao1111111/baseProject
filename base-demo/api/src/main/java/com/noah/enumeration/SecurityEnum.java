package com.noah.enumeration;

import org.assertj.core.util.diff.Delta;

import java.util.HashMap;
import java.util.Map;

/**
 * 安全管理-URL权限拦截 URL权限初始化 CSRF  数据权限拦截
 *
 * @Author: WangXinWei
 * @Date: 2020/1/6 18:00
 * @Version 1.0
 */
public enum SecurityEnum {
    URL_ACCESS_INTERCEPTOR(1, "url权限拦截"),
    URL_ACCESS_INIT(2, "url权限初始化"),
    CSRF(3, "CRSF拦截"),
    DATA_INTERCEPTOR(4, "数据权限拦截");
    private Integer type;
    private String desc;

    SecurityEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private static final Map<Integer, String> TYPE_DESC_MAP = new HashMap<Integer, String>(4);

    static {
        for (SecurityEnum securityEnum : values()) {
            TYPE_DESC_MAP.put(securityEnum.type, securityEnum.desc);
        }

    }

    /**
     * 通过类型获取描述
     *
     * @param type
     * @return
     */
    public static String getDescByType(Integer type) {
        return TYPE_DESC_MAP.get(type);
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
