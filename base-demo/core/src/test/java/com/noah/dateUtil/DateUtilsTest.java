package com.noah.dateUtil;

import com.noah.util.DateUtils;

import java.util.Date;

/**
 * @Author: WangXinWei
 * @Date: 2019/12/10 14:46
 * @Version 1.0
 */
public class DateUtilsTest {
    public static void main(String[] args) {

        // 获取字符串类型的当前日期,格式为:yyyy-MM-dd
        /*String currentDate = DateUtils.getCurrentDate();
        System.out.println("获取当前日期 " + currentDate);*/

        // 获取自定义格式的当前日期
       /* String date = DateUtils.getCustomizeCurrentDate("yyyyMM");
       System.out.println("获取自定义格式的当前日期: " + date);*/

        // 日期转成字符串
       /* Date date1 = new Date();
        String dateToString = DateUtils.dateToString(date1, "yyyy-MM-dd");
        System.out.println("日期转成字符串 = " + dateToString);*/

        // 将字符串日期转换为Date格式日期
        /*String stringDate = "2019-01";
        Date date = DateUtils.stringToDate(stringDate);
        System.out.println("将字符串日期转换为Date格式日期 = " + date);*/

        // 方式二: 将字符串日期转换为Date类型的日期
        /*String stringDate = "2019-11-22";
        Date date = DateUtils.stringToDateWayTwo(stringDate);
        System.out.println("date = " + date);*/

        // 方式一: 获取年
        /*String date = "2019-01";
        int year = DateUtils.getYear(date);
        System.out.println("方式一: 获取年 = " + year);*/

        // 方式二:  获取年
        /*String date = "2019-03-02";
        int yearWayTwo = DateUtils.getYearWayTwo(date);
        System.out.println("方式二:  获取年 = " + yearWayTwo);*/

        // 方式一: 获取月
        /*String date = "2019-03";
        int month = DateUtils.getMonth(date, "yyyy-MM");
        System.out.println("方式一: 获取月 = " + month);*/

        // 方式二: 获取月
        /*String date = "2019-02-01";
        int monthWayTwo = DateUtils.getMonthWayTwo(date);
        System.out.println("方式二: 获取月 = " + monthWayTwo);*/

        // 方式一: 获取天
        /*String date = "2019-03-23";
        int day = DateUtils.getDay(date, "yyyy-MM-dd");
        System.out.println("方式一: 获取天 = " + day);*/

        // 方式二: 获取天
        /*String date = "2019-04-23";
        int dayWayTwo = DateUtils.getDayWayTwo(date);
        System.out.println("方式二: 获取天 = " + dayWayTwo);*/

        // 方式一: 获取星期
        /*String date = "2019-12-11";
        String week = DateUtils.getWeek(date, "yyyy-MM-dd");
        System.out.println("方式一: 获取星期 = " + week);*/

        // 方式二: 获取星期
        /*String date = "2019-12-12";
        String weekWayTwo = DateUtils.getWeekWayTwo(date);
        System.out.println("方式二: 获取星期 = " + weekWayTwo);*/

        // 方式一: 获取某月的第一天最小时间(2018-01-01 00:00:00)
        /*String date = "2018-03-23";
        Date firstDay = DateUtils.getFirstDay(date);
        System.out.println("方式一: 获取某月的第一天最小时间(2018-01-01 00:00:00) = " + firstDay);*/

        // 方式二:    获取某月的第一天最小时间(2018-01-01 00:00:00)
        /*String date = "2017-02-21";
        Date firstDayWayTwo = DateUtils.getFirstDayWayTwo(date);
        System.out.println("方式二:    获取某月的第一天最小时间(2018-01-01 00:00:00) = " + firstDayWayTwo);*/

        // 方式一:    获取某月的最后一天最小时间("2019-01-30 00:00:00")
        /*String date = "2017-02-02";
        Date lastDay = DateUtils.getLastDay(date);
        System.out.println("方式一:    获取某月的最后一天最小时间(\"2019-01-30 00:00:00\") = " + lastDay);*/

        // 方式二: 获取某月的最后一天最小时间("2019-01-30 00:00:00")
        /*String date = "2019-04-03";
        Date lastDayWayTwo = DateUtils.getLastDayWayTwo(date);
        System.out.println("方式二: 获取某月的最后一天最小时间(\"2019-01-30 00:00:00\") = " + lastDayWayTwo);*/

        // 获取某月第一天的最大时间("2019-01-01 23:59:59")
        /*String date = "2018-02-23";
        Date firstDayMax = DateUtils.getFirstDayMax(date);
        System.out.println("获取某月第一天的最大时间(\"2019-01-01 23:59:59\") = " + firstDayMax);*/

        // 获取某月最后一天最大时间(2019-2-30 23:59:59)
        /*String date = "2019-12-11";
        Date lastDayMax = DateUtils.getLastDayMax(date);
        System.out.println("获取某月最后一天最大时间(2019-2-30 23:59:59) = " + lastDayMax);*/

        // 获取当天最小时间("2019-01-02 00:00:00")
        /*Date startTimeOfDay = DateUtils.getStartTimeOfDay();
        System.out.println("获取当天最小时间(\"2019-01-02 00:00:00\") = " + startTimeOfDay);*/

        // 获取当天最大时间("2019-01-05")
        /*Date endTimeOfDay = DateUtils.getEndTimeOfDay();
        System.out.println("获取当天最大时间(\"2019-01-05\") = " + endTimeOfDay);*/

        // 是否闰年
        /*Boolean leapYear = DateUtils.isLeapYear("2019-01-02");
        System.out.println("是否闰年 = " + leapYear);*/

        // 方式二: 是否闰年
        /*Boolean leapYearWayTwo = DateUtils.isLeapYearWayTwo("2019-11-01");
        System.out.println("方式二: 是否闰年 = " + leapYearWayTwo);*/

        // 方式三: 是否闰年
       /* Boolean leapYearWayThree = DateUtils.isLeapYearWayThree("1720-01-01");
        System.out.println("方式三: 是否闰年 = " + leapYearWayThree);*/

        // 根据输入的年月日,生成完整日期
        /*Date dateByYMD = DateUtils.getDateByYMD(1, 2, 3);
        System.out.println("根据输入的年月日,生成完整日期 = " + dateByYMD);*/

        // 获取该月的日历及对应星期
        /*Map<String, List<?>> monthDayAndWeek =
                DateUtils.getMonthDayAndWeek("2019-12-01");
        System.out.println("获取该月的日历及对应星期 = " + monthDayAndWeek);*/

        // 获取该日期未来某年对应的日期
        /*Date futureDateByYear = DateUtils.getFutureDateByYear("2015-01-03", 2);
        System.out.println("获取该日期未来某年对应的日期 = " + futureDateByYear);*/

        // 获取该日期未来某月对应的日期
        /*Date futureDateByMonth = DateUtils.getFutureDateByMonth("2013-02-03", 2);
        System.out.println("获取该日期未来某月对应的日期 = " + futureDateByMonth);*/

        // 相差多少年,多少月,多少天
        /*int subYear = DateUtils.differenceYearOfDate("2019-11-23", "2016-01-01", "年");
        int subMonth = DateUtils.differenceYearOfDate("2019-11-23", "2013-11-23", "月");
        int subDay = DateUtils.differenceYearOfDate("2019-03-01", "2019-2-28", "天");
        System.out.println("相差多少年 = " + subYear);
        System.out.println("相差多少月 = " + subMonth);
        System.out.println("相差多少天 = " + subDay);*/

        // 计算年龄
        /*int calcAge = DateUtils.calcAge("1993-03-15", "2019-12-11");
        System.out.println("计算年龄 = " + calcAge);*/

        // 获取身份证上的日期
        /*String birthdayFromIDCard = DateUtils.getBirthdayFromIDCard("142733199303153311");
        System.out.println("获取身份证上的日期 = " + birthdayFromIDCard);*/

        // 自定义当前日期天数
        /*String strDate = "2020-07-05";
        Date date = DateUtils.stringToDate(strDate);
        Date currentDate = DateUtils.customizeCurrentDateDay(date, 10);
        System.out.println("将当前日期：2020-7-5 修改为：" + currentDate);*/

        // 日期转为时间戳
      /*  String strDate = "2020-07-31";
        String stamp = DateUtils.strDateToStamp(strDate);
        System.out.println("日期转为时间戳: " + stamp);*/

      // 时间戳转为日期
      /*  String stamp = "1596124800000";
        String date = DateUtils.stampToDate(stamp);
        System.out.println("时间戳转为日期: " + date);*/

    }

}
