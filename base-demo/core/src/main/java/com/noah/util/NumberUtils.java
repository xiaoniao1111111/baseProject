package com.noah.util;

import com.noah.constants.CharConstants;
import com.noah.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * 数值转换工具
 *
 * @Author: WangXinWei
 * @Date: 2019/12/16 10:52
 * @Version 1.0
 */
@Slf4j
public class NumberUtils {

    /**
     * 一亿的BigDecimal类型常量
     */
    private static final BigDecimal BIGDECIMAL_HUNDRED_MILLION = new BigDecimal(100000000);
    /**
     * 一万的BigDecimal类型常量
     */
    private static final BigDecimal BIGDECIMAL_TEN_THOUSAND = new BigDecimal(10000);
    /**
     * 一百的BigDecimal类型常量
     */
    private static final BigDecimal BIGDECIMAL_HUNDRED = new BigDecimal(100);
    /**
     * 百万的BigDecimal类型常量
     */
    private static final BigDecimal BIGDECIMAL_MILLION = new BigDecimal(1000000);

    /**
     * 字符串转为BigDecimal
     *
     * @param value
     * @return
     */
    public static BigDecimal stringToBigDecimal(String value) {

        if (isNotValidNumber(value)) {
            return null;
        }
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            log.error("字符串转换数值出现异常,value:{},异常信息：{}", value, e);
        }

        return null;
    }

    /**
     * BigDecimal转为string并保留位数
     *
     * @param bigDecimal BigDecimal类型值
     * @param scale      保留位数
     * @return
     */
    public static String bigDecimalToString(BigDecimal bigDecimal, int scale) {
        if (StringUtils.isEmpty(bigDecimal)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("#0");
        for (int i = 0; i < scale; i++) {
            if (i == 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append("0");
        }
        DecimalFormat decimalFormat = new DecimalFormat(stringBuilder.toString());
        return decimalFormat.format(bigDecimal.setScale(scale, RoundingMode.HALF_UP));
    }

    /**
     * 以"亿"为单位转换为以"个"为单位,数组大于等于1000用逗号隔开,并保留两位小数
     *
     * @param origin 原始数值
     * @return
     */
    public static String convertHundredMillion(String origin) {
        BigDecimal bigDecimal = stringToBigDecimal(origin);
        if (bigDecimal == null) {
            return CharConstants.MINUS_SIGN;
        }
        BigDecimal decimal = bigDecimal.multiply(NumberUtils.BIGDECIMAL_HUNDRED_MILLION).setScale(2, RoundingMode.HALF_UP);
        return NumberFormat.getInstance().format(decimal);
    }

    /**
     * 转换为以”万“为单位，并保留两位小数
     *
     * @param origin 原始数值
     * @return
     */
    public static String convertMillion(String origin) {
        if (isNotValidNumber(origin)) {
            return origin;
        }
        return new BigDecimal(origin)
                .divide(BIGDECIMAL_TEN_THOUSAND, 2, RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP)
                .toString();
    }

    /**
     * 金额超过1000,则用逗号分隔并保留自定义位数
     *
     * @param origin 原始值
     * @param scale  保留位数
     * @return
     */
    public static String amountFormatRetentionDigit(String origin, int scale) {
        if (isNotValidNumber(origin)) {
            return origin;
        }
        BigDecimal bigDecimal = stringToBigDecimal(origin);
        DecimalFormat decimalFormat = new DecimalFormat(",###,##0.00");
        assert bigDecimal != null;
        return decimalFormat.format(bigDecimal.setScale(scale, RoundingMode.HALF_UP));
    }

    /**
     * 转化为百分比并保留自定义位数
     *
     * @param origin 原始值
     * @param scale  保留位数
     * @return
     */
    public static String convertPercentage(String origin, int scale) {

        BigDecimal bigDecimal = stringToBigDecimal(origin);
        if (null == bigDecimal) {
            return "0.00%";
        }
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMinimumFractionDigits(scale);
        return percentInstance.format(bigDecimal);
    }

    /**
     * 将千分位分隔的字符串转换为BigDecimal
     *
     * @param origin
     * @return
     */
    public static BigDecimal commaStringToBigDecimal(String origin) {
        if (isNotValidNumber(origin)) {
            return BigDecimal.ZERO;
        }
        NumberFormat instance = NumberFormat.getInstance();
        try {
            return new BigDecimal(instance.parse(origin).doubleValue()).setScale(6, RoundingMode.HALF_UP);
        } catch (ParseException e) {
            throw new BizException("数值转换异常", e);
        }
    }

    /**
     * 将百分比类的小数转换为数值(0.03->3)
     *
     * @param origin 原始值
     * @return
     */
    public static String convertNumber(String origin) {

        if (isNotValidNumber(origin)) {
            return origin;
        }
        return new BigDecimal(origin).multiply(new BigDecimal(100)).setScale(6, RoundingMode.HALF_UP).toString();
    }

    /**
     * 是否是不合法数据，为null,"-"都是不合法数据
     *
     * @param origin 原始值
     * @return
     */
    public static Boolean isNotValidNumber(String origin) {
        return origin == null || "null".equals(origin) || origin.equals(CharConstants.MINUS_SIGN);
    }

}
