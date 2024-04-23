package com.noah.constants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 星期枚举
 *
 * @Author: WangXinWei
 * @Date: 2019/12/10 17:36
 * @Version 1.0
 */
public enum WeekEnum {
    MONDAY(1, "一"),
    TUESDAY(2, "二"),
    WEDNESDAY(3, "三"),
    THURSDAY(4, "四"),
    FRIDAY(5, "五"),
    SATURDAY(6, "六"),
    SUNDAY(7, "日");
    private Integer code;
    private String name;

    WeekEnum() {
    }

    WeekEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<Integer, String> WEEK_MAP = new HashMap<>(8);

    static {
        for (WeekEnum weekEnum : WeekEnum.values()) {
            WEEK_MAP.put(weekEnum.getCode(), weekEnum.getName());
        }
    }

    public static String getNameByCode(Integer code) {
        if (Objects.isNull(code)) {
            return null;
        }
        return WEEK_MAP.get(code);
    }


}
