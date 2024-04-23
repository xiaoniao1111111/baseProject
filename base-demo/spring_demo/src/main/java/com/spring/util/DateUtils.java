package com.spring.util;


import com.noah.constants.WeekEnum;
import com.noah.exception.BizException;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * 日期工具类
 *
 * @Author: WangXinWei
 * @Date: 2019/12/10 11:30
 * @Version 1.0
 */
public class DateUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_MONTH_FORMAT = "yyyy-MM";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
    public static final String DATE_MONTH_FORMAT_CHINESE = "yyyy年MM月";

    /**
     * 获取字符串类型的当前日期,格式为:yyyy-MM-dd
     * 例: "2018-01-01"
     *
     * @return  返回值
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(new Date());
    }

    /**
     * 获取自定义格式的当前日期
     *
     * @param format 日期格式
     * @return
     */
    public static String getCustomizeCurrentDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    /**
     * 日期转成字符串
     *
     * @param date   日期
     * @param format 日期格式
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 方式一: 将字符串日期转换为Date格式日期
     *
     * @param stringDate 字符串日期("yyyy-MM-dd")
     * @return
     */
    public static Date stringToDate(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        try {
            date = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            date = stringToDate(stringDate, "yyyyMMdd");
        }
        return date;
    }

    /**
     * 将字符串转成自定义格式Date类型的日期
     *
     * @param stringDate 字符串日期
     * @param format     日期格式
     * @return
     */
    public static Date stringToDate(String stringDate, String format) {
        Date date = new Date();
        if (StringUtils.isEmpty(stringDate) && StringUtils.isEmpty(format)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {

            date = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 方式二: 将字符串日期转换为Date类型的日期
     *
     * @param stringToDate 字符串日期(格式必须为:"2018-01-01")
     *                     否则解析异常
     * @return
     */
    public static Date stringToDateWayTwo(String stringToDate) {
        if (StringUtils.isEmpty(stringToDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringToDate);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 方式一: 获取年
     *
     * @param stringDate 字符串日期
     * @return
     */
    public static Integer getYear(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        Date date = stringToDate(stringDate);
        Calendar instance = Calendar.getInstance();
        assert date != null;
        instance.setTime(date);
        return instance.get(Calendar.YEAR) + 1;
    }

    /**
     * 方式二:  获取年
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Integer getYearWayTwo(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        return localDate.getYear();
    }

    /**
     * 方式一: 获取月
     *
     * @param stringDate 字符串日期
     * @param format     日期格式
     * @return
     */
    public static Integer getMonth(String stringDate, String format) {
        if (StringUtils.isEmpty(stringDate) && StringUtils.isEmpty(format)) {
            return null;
        }
        Calendar calendar = calendarInitialer(stringDate, format);
        assert calendar != null;
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 方式二: 获取月
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Integer getMonthWayTwo(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        return localDate.getMonthValue();
    }

    /**
     * 方式一: 获取天
     *
     * @param stringDate 字符串日期
     * @param format     日期格式
     * @return
     */
    public static Integer getDay(String stringDate, String format) {
        Calendar calendar = calendarInitialer(stringDate, format);
        assert calendar != null;
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 方式二: 获取天
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Integer getDayWayTwo(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        return localDate.getDayOfMonth();
    }

    /**
     * 方式一: 获取星期
     *
     * @param stringDate 字符串日期
     * @param format     日期格式
     * @return
     */
    public static String getWeek(String stringDate, String format) {
        Calendar calendar = calendarInitialer(stringDate, format);
        assert calendar != null;
        return String.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1);
    }

    /**
     * 方式二: 获取星期
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static String getWeekWayTwo(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        return String.valueOf(localDate.getDayOfWeek().getValue());
    }

    /**
     * 方式一: 获取某月的第一天最小时间(2018-01-01 00:00:00)
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Date getFirstDay(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        LocalDate first = localDate.with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(first.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 方式二:    获取某月的第一天最小时间(2018-01-01 00:00:00)
     *
     * @param stringDate 字符串日期 (格式必须为:"2018-01-01")
     * @return
     */
    public static Date getFirstDayWayTwo(String stringDate) {
        Date date = stringToDate(stringDate);
        assert date != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime firstDay = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        return Date.from(firstDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 方式一:    获取某月的最后一天最小时间("2019-01-30 00:00:00")
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Date getLastDay(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return Date.from(lastDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 方式二: 获取某月的最后一天最小时间("2019-01-30 00:00:00")
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Date getLastDayWayTwo(String stringDate) {
        Date date = stringToDate(stringDate);
        assert date != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime lastDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MIN);
        return Date.from(lastDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取某月第一天的最大时间("2019-01-01 23:59:59")
     *
     * @param stringDate 字符串日期(格式必须为:"2019-01-02")
     * @return
     */
    public static Date getFirstDayMax(String stringDate) {
        Date date = stringToDate(stringDate);
        assert date != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        LocalDateTime firstDayMax = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MAX);
        return Date.from(firstDayMax.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取某月最后一天最大时间(2019-2-30 23:59:59)
     *
     * @param stringDate 字符串日期(格式必须为:"2018-01-01")
     * @return
     */
    public static Date getLastDayMax(String stringDate) {
        Date date = stringToDate(stringDate);
        assert date != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime lastDayMax = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return Date.from(lastDayMax.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当天最小时间("2019-01-02 00:00:00")
     *
     * @return
     */
    public static Date getStartTimeOfDay(Date currentDate) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentDate.getTime()), ZoneId.systemDefault());
        LocalDateTime startTimeOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startTimeOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当天最大时间("2019-03-23 23:59:59")
     *
     * @return
     */
    public static Date getEndTimeOfDay(Date currentDate) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentDate.getTime()), ZoneId.systemDefault());
        LocalDateTime endTimeOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endTimeOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * calendar初始化
     *
     * @param stringDate 字符串日期
     * @param format     日期格式
     * @return
     */
    public static Calendar calendarInitialer(String stringDate, String format) {
        if (StringUtils.isEmpty(stringDate) && StringUtils.isEmpty(format)) {
            return null;
        }
        Date date = stringToDate(stringDate, format);
        Calendar instance = Calendar.getInstance();
        assert date != null;
        instance.setTime(date);
        return instance;
    }

    /**
     * 是否闰年
     *
     * @param stringDate 字符串日期
     * @return
     */
    public static Boolean isLeapYear(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        Calendar calendar = calendarInitialer(stringDate, DATE_FORMAT);
        assert calendar != null;
        int year = calendar.getWeekYear();
        return year % 4 == 0 && year % 100 != 0 | year % 400 == 0;
    }

    /**
     * 方式二: 是否闰年
     *
     * @param stringDate 字符串日期(格式必须为:"2019-01-11")
     * @return
     */
    public static Boolean isLeapYearWayTwo(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        Date date = stringToDate(stringDate);
        assert date != null;
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        int year = localDateTime.getYear();
        return year % 4 == 0 && year % 100 != 0 | year % 400 == 0;
    }

    public static Boolean isLeapYearWayThree(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(stringDate);
        return localDate.isLeapYear();
    }

    /**
     * 根据输入的年月日,生成完整日期
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return
     */
    public static Date getDateByYMD(int year, int month, int day) {
        if (year <= 0 || month <= 0 || day <= 0) {
            throw new BizException("传入的年月日有误");
        }
        LocalDate localDate = LocalDate.of(year, month, day);
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取该月的日历及对应星期
     *
     * @param stringDate 字符串日期(日期格式必须为:"2019-02-23")
     * @return
     */
    public static Map<String, List<?>> getMonthDayAndWeek(String stringDate) {
        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }
        Date date = stringToDate(stringDate);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        // 获取这个月的第一天
        LocalDateTime firstDay = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        int stratDay = firstDay.getDayOfMonth();
        // 获取这个月的最后一天
        LocalDateTime lastDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        int endDay = lastDay.getDayOfMonth();
        // 获取第一天的星期
        int firstDayWeek = firstDay.getDayOfWeek().getValue();
        List<Integer> dayOfMonthList = new ArrayList<>();
        List<String> wekkList = new ArrayList<>();
        for (int i = stratDay; i <= endDay; i++) {
            dayOfMonthList.add(i);
            wekkList.add(WeekEnum.getNameByCode(firstDayWeek));
            if (firstDayWeek == 7) {
                firstDayWeek = 1;
            } else {
                firstDayWeek++;
            }
        }
        Map<String, List<?>> map = new HashMap<>();
        map.put("dayOfMonth", dayOfMonthList);
        map.put("week", wekkList);
        return map;
    }

    /**
     * 获取该日期未来某年对应的日期
     *
     * @param stringDate 字符串日期
     * @param year       年
     * @return
     */
    public static Date getFutureDateByYear(String stringDate, int year) {
        Calendar calendar = calendarInitialer(stringDate, DATE_FORMAT);
        assert calendar != null;
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 获取该日期未来某月对应的日期
     *
     * @param stringDate 字符串日期
     * @param month      月
     * @return
     */
    public static Date getFutureDateByMonth(String stringDate, int month) {
        Calendar calendar = calendarInitialer(stringDate, DATE_FORMAT);
        assert calendar != null;
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 相差多少年,多少月,多少天
     *
     * @param firstDate 第一个字符串日期
     * @param lastDate  第二个字符串日期
     * @param type      类型(年,月,日)
     * @return
     */
    public static int differenceYearOfDate(String firstDate, String lastDate, String type) {
        int number = 0;
        if (StringUtils.isEmpty(type)) {
            throw new BizException("传入类型有误");
        }
        Date firstDay = stringToDate(firstDate);
        Date lastDay = stringToDate(lastDate);
        assert firstDay != null;
        LocalDateTime firstLocalTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(firstDay.getTime()), ZoneId.systemDefault());
        assert lastDay != null;
        LocalDateTime lastLocalTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastDay.getTime()), ZoneId.systemDefault());
        switch (type) {
            case "年": {
                number = firstLocalTime.getYear() - lastLocalTime.getYear();
                break;
            }
            case "月": {
                number = firstLocalTime.getYear() * 12 + firstLocalTime.getMonthValue() - lastLocalTime.getYear() * 12 - lastLocalTime.getMonthValue();
                break;
            }
            case "天": {
                long fd = firstDay.getTime();
                long td = lastDay.getTime();
                number = (int) ((fd - td) / (24L * 60L * 60L * 1000L));
                break;
            }
        }

        return number;
    }

    /**
     * 计算年龄
     *
     * @param birthDay 生日日期
     * @param calcDate 计算日期(比如在"2019-01-01"他多大)
     * @return
     */
    public static int calcAge(String birthDay, String calcDate) {
        int cYear = getYear(calcDate);
        int cMonth = getMonth(calcDate, DATE_FORMAT);
        int cDay = getDay(calcDate, DATE_FORMAT);
        int bYear = getYear(birthDay);
        int bMonth = getMonth(birthDay, DATE_FORMAT);
        int bDay = getDay(birthDay, DATE_FORMAT);
        if (cMonth > bMonth || cMonth == bMonth && cDay > bDay) {
            return cYear - bYear;
        } else {
            return cYear - 1 - bYear;
        }
    }

    /**
     * 获取身份证上的日期
     *
     * @param idno 身份证信息
     * @return
     */
    public static String getBirthdayFromIDCard(String idno) {
        Calendar instance = Calendar.getInstance();
        if (idno.length() == 15) {
            instance.set(Calendar.YEAR, Integer.valueOf(idno.substring(6, 8)));
            instance.set(Calendar.MONTH, Integer.valueOf(idno.substring(8, 10)) - 1);
            instance.set(Calendar.DAY_OF_MONTH, Integer.valueOf(idno.substring(10, 12)));
        } else if (idno.length() == 18) {
            instance.set(Calendar.YEAR, Integer.valueOf(idno.substring(6, 10)));
            instance.set(Calendar.MONTH, Integer.valueOf(idno.substring(10, 12)) - 1);
            instance.set(Calendar.DAY_OF_MONTH, Integer.valueOf(idno.substring(12, 14)));
        }
        return dateToString(instance.getTime(), DATE_FORMAT);
    }

    /**
     * 自定义当前日期天数
     * 例：当前日期：2020-7-5  修改天数为10号   修改后： 2020-7-10
     *
     * @param currentDate
     * @param dayOfMonth
     * @return
     */
    public static Date customizeCurrentDateDay(Date currentDate, int dayOfMonth) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
        LocalDateTime customizeDate = localDateTime.withDayOfMonth(dayOfMonth);
        return Date.from(customizeDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 时间戳转为日期
     *
     * @param stamp 时间戳
     * @return
     */
    public static String stampToDate(String stamp) {
        // 1. 日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 2. 字符串时间戳转为Long
        Long s = new Long(stamp);
        try {
            // 3. 将Long类型的时间戳转为日期
            Date date1 = new Date(s);
            // 4. 日期转为字符串日期
            return dateFormat.format(date1);
        } catch (Exception e) {
            throw new BizException("日期转换异常,异常信息:{}", e);
        }
    }

    /**
     * 日期转为时间戳
     *
     * @param strDate 日期
     * @return
     */
    public static String strDateToStamp(String strDate) {
        // 1. 日期格式化对象
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 2. 字符串日期转为日期
            Date date = dateFormat.parse(strDate);
            // 3. 日期转为时间戳并转为字符串
            return String.valueOf(date.getTime());
        } catch (ParseException e) {
            throw new BizException("日期转换异常,异常信息:{}", e);
        }
    }
}
