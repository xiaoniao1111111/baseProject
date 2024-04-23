package com.leyou.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class BigDecimalUtil {

    /**
     * 数字字符串去除小数点后末尾多余的0
     * 如果字符串为空返回0，非数字则返回原字符串
     * @param str
     * @return
     */
    public static String numberRemoveZero(String str) {
        String str2 = "";
        if (str == null || "".equals(str)) {
            str2 = "0";
        } else {
            try {
                BigDecimal b = new BigDecimal(str);
                //java1.7BigDecimal的stripTrailingZeros处理0.00没生效
                if (b.compareTo(BigDecimal.ZERO) == 0) {
                    str2 = "0";
                } else {
                    str2 = b.stripTrailingZeros().toPlainString();
                }
            } catch (Exception e) {
                log.error("数字转化异常", str + e.toString());
                str2 = str;
            }
        }
        return str2;
    }


    /**
     * 检测多个可为null的数字的排序是否从小到大
     *
     * @param list
     * @return
     */
    public static boolean checkBigDecimalSortUp(List<BigDecimal> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            BigDecimal history = null;
            Iterator<BigDecimal> iterator = list.iterator();
            while (iterator.hasNext()) {
                BigDecimal next = iterator.next();
                if (history == null || next.compareTo(history) > 0) {
                    history = next;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
