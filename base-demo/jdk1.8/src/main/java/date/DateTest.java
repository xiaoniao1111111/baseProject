package date;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * JDK1.8(Java8)新特性--Date
 *
 * @Author: WangXinWei
 * @Date: 2019/12/11 14:22
 * @Version 1.0
 */

public class DateTest {

    @Test
    public void getInstant() {
        // 获取当前时间戳
        /*Instant instant = Instant.now();
        System.out.println("获取当前时间戳 = " + instant);*/

        // 将日期转换成时间戳
        /*Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println("将日期转换成时间戳 = " + instant);*/

        // 将时间戳转换成日期
        /*Instant instant = Instant.now();
        Date date = Date.from(instant);
        System.out.println("将时间戳转换成日期 = " + date);*/

        // 获取当前时间
        /*LocalDate currentDate = LocalDate.now();
        System.out.println("获取当前时间 = " + currentDate);*/

        // 获取当前时间的年月日
        /*LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int monthValue = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        System.out.println("year: " + year + " month: " + monthValue + " day: " + day);*/

        // 获取自定义日期
        /*LocalDate localDate = LocalDate.of(2011, 01, 02);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("获取自定义日期 = " + date);*/

        // 检测两个日期是否相等
        /*LocalDate localDate = LocalDate.of(2012, 02, 03);
        LocalDate nowLocalDate = LocalDate.now();
        boolean equals = localDate.equals(nowLocalDate);
        System.out.println("检测两个日期是否相等 = " + equals);*/

        // 检查重复事件(比如节日,生日)
        /*LocalDate localDate = LocalDate.of(2019, 06, 01);
        LocalDate nowLocalDate = LocalDate.now();
        MonthDay festival = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay currentDate = MonthDay.from(nowLocalDate);
        if (currentDate.equals(localDate)) {
            System.out.println("今天是儿童节");
        } else {
            System.out.println("很抱歉今天不是节假日");
        }*/


        LocalDate currentDate = LocalDate.now();
        // 以当前时间为准,获取未来几周后的日期(以星期为单位)     前: 2020-07-10    后: 2020-07-17
        /*LocalDate oneWeekAgo = currentDate.plus(1, ChronoUnit.WEEKS);
        System.out.println("获取一周后的日期: " + oneWeekAgo);*/

        // 以当期时间为准,获取过去几周前的日期(以星期为单位)   前: 2020-07-10    后: 2020-07-03
        /*LocalDate oneWeekLater = currentDate.minus(1, ChronoUnit.WEEKS);
        System.out.println("获取一周前的日期: " + oneWeekLater);*/

        // 以当期日期为准,获取未来几天后的日期(以天为单位)  前: 2020-07-10  后:  2020-07-11
        /*LocalDate plus = currentDate.plus(1, ChronoUnit.DAYS);
        System.out.println("plus = " + plus);*/

        // 以当前时间为准,获取几天前的日期(以天为单位)   前: 2020-07-10  后: 2020-07-09
        /*LocalDate minus = currentDate.minus(1, ChronoUnit.DAYS);
        System.out.println("获取过去几天前的日期: " + minus);*/

        // 以当前时间为准,几个十年后的日期(以10年为单位)  前: 2020-07-10   后: 2030-07-10
        /*LocalDate plus = currentDate.plus(1, ChronoUnit.DECADES);
        System.out.println("几个十年后的日期: " + plus);*/

        // 以当前时间为准,几个十年前的日期(以10年为单位)    前; 2020-07-10    后: 2010-07-10
        /*LocalDate minus = currentDate.minus(1, ChronoUnit.DECADES);
        System.out.println("几个十年前的日期: " + minus);*/

        // 以当前时间为准,几个世纪后的日期(1个世纪=100年,以世纪为单位)    前; 2020-07-10    后:  2120-07-10
        /*LocalDate plus = currentDate.plus(1, ChronoUnit.CENTURIES);
        System.out.println("几个世纪后的日期: " + plus);*/

        // 以当前时间为准,几个世纪前的日期(1个世纪=100年,以世纪为单位)    前; 2020-07-10   后: 1920-07-10
        /*LocalDate minus = currentDate.minus(1, ChronoUnit.CENTURIES);
        System.out.println("几个世纪前的日期: " + minus);*/

        /*LocalDate plus = currentDate.plus(1, ChronoUnit.ERAS);
        System.out.println("plus = " + plus);*/

        /*LocalDate minus = currentDate.minus(1, ChronoUnit.FOREVER);
        System.out.println("minus = " + minus);*/

        // 判断某个日期在另一个日期之前还是之后
        /*LocalDate nowLocalDate = LocalDate.now();
        LocalDate dayBefore = nowLocalDate.plus(1, ChronoUnit.DAYS);
        System.out.println("前一天是否在当前日期的前面 = " + nowLocalDate.isBefore(dayBefore));
        System.out.println("前一天是否在当前日期的后面 = " + nowLocalDate.isAfter(dayBefore));*/

        // 两个日期相差多少天多少月
        /*LocalDate localDate = LocalDate.now();
        LocalDate twoDayAgo = localDate.plus(2, ChronoUnit.MONTHS);
        Period between = Period.between(localDate,twoDayAgo);
        System.out.println("相差多少月 = " + between.getMonths()+" 两个当天几号相差多少: "+between.getDays());*/

        // 获取当前时间 并得到两小时后时间
        /*LocalTime localTime = LocalTime.now();
        LocalTime twoHourAgo = localTime.plusHours(2);
        System.out.println("获取当前时间 = " + localTime);
        System.out.println("两小时后的时间 = " + twoHourAgo);*/

        //  通过时钟获取当前时间时间戳
        /*Clock clock = Clock.systemUTC();
        System.out.println("获取时间戳 = " + clock.instant().atZone(ZoneId.systemDefault()));*/

        // 获取本地时间包含年月日时分秒
        /*LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("获取本地时间包含年月日时分秒 = " + localDateTime);*/

        // date 转 LocalDateTime
        /*Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("日期转为localDateTime: " + localDateTime);*/

        // 字符串日期转为 LocalDate
     /*   String strDate = "2020-07-05";
        LocalDate localDate = LocalDate.parse(strDate);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDate转为Date： " + date);*/

        // LocalDateTime 转为 Date
        /*Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime转为Date: " + date1);*/

        // 获取某年第N天的日期   前: 2020年第320天    后: 2020-11-15
        /*LocalDate ofYearDay = LocalDate.ofYearDay(2020, 320);
        System.out.println("获取2020年第320天的日期: " + ofYearDay);*/

        // 如果想知道今天是一年中的第几天   前: 2020-7-10   后: 192
        /*int dayOfYear = currentDate.getDayOfYear();
        System.out.println("今天是一年中的第: " + dayOfYear + "天");*/

        // 如果想知道今天是一个月中的第几天   前: 2020-7-10    后: 10
        /*int dayOfMonth = currentDate.getDayOfMonth();
        System.out.println("今天是一个月中的第: " + dayOfMonth + "天");*/

        // 如果想知道今天是这周中的第几天   前: 2020-7-10   后: 5
        /*int dayOfWeek = currentDate.getDayOfWeek().getValue();
        System.out.println("今天是这周中的第: " + dayOfWeek + "天");*/



        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // 获取某月第一天
        /*LocalDateTime firstDayOfMonth = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        Date firstDay = Date.from(firstDayOfMonth.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("获取某月第一天: " + firstDay);*/

        // 获取某月最后一天
        /*LocalDateTime lastDayOfMonth = localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        Date lastDay = Date.from(lastDayOfMonth.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("获取某月最后一天: " + lastDay);*/

        // 获取某天最小时间
        /*LocalDateTime minDay = localDateTime.with(LocalTime.MIN);
        Date from = Date.from(minDay.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("获取某天最小时间: " + from);*/

        // 获取某天最大时间
        /*LocalDateTime maxDay = localDateTime.with(LocalTime.MAX);
        Date from = Date.from(maxDay.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("获取某天最大时间: " + from);*/

    }

}
