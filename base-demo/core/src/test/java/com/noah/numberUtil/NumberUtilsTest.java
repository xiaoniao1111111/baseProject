package com.noah.numberUtil;

import com.noah.exception.BizException;
import com.noah.util.NumberUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 数值工具测试
 *
 * @Author: WangXinWei
 * @Date: 2019/12/16 14:17
 * @Version 1.0
 */
public class NumberUtilsTest {
    public static void main(String[] args) {

        /*//字符串转为BigDecimal
        BigDecimal bigDecimal = NumberUtils.stringToBigDecimal("11.2323323");
        System.out.println("字符串转为BigDecimal: " + bigDecimal);*/

        /*// BigDecimal转为string并保留位数
        String decimalToString = NumberUtils.bigDecimalToString(new BigDecimal(11.22222), 2);
        System.out.println("BigDecimal转为string并保留位数: " + decimalToString);*/

        /*// 以"亿"为单位转换为以"个"为单位,数组大于等于1000用逗号隔开,并保留两位小数
        String hundredMillion = NumberUtils.convertHundredMillion("2");
        System.out.println("转换为以个为单位: " + hundredMillion);*/

        /*// 转换为以”万“为单位，并保留两位小数
        String convertMillion = NumberUtils.convertMillion("120000");
        System.out.println("换为以”万“为单位，并保留两位小数: " + convertMillion);*/

        /*// 金额超过1000,则用逗号分隔并保留自定义位数
        String retentionDigit = NumberUtils.amountFormatRetentionDigit("123456", 2);
        System.out.println("金额超过1000,则用逗号分隔并保留自定义位数: " + retentionDigit);*/

        /*// 转化为百分比并保留自定义位数
        String convertPercentage = NumberUtils.convertPercentage("0.123", 2);
        System.out.println("转化为百分比并保留自定义位数: " + convertPercentage);*/

       /* // 将千分位分隔的字符串转换为BigDecimal
        BigDecimal bigDecimal = NumberUtils.commaStringToBigDecimal("111,222,2");
        System.out.println("将千分位分隔的字符串转换为BigDecimal = " + bigDecimal);*/

        // 将百分比类的小数转换为数值
        String convertNumber = NumberUtils.convertNumber("0.33");
        System.out.println("将百分比类的小数转换为数值: " + convertNumber);
    }
}
