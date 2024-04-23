import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/2 16:16
 * @Version 1.0
 */
public class NewDateTest {
    public static void main(String[] args) {

        // 获取当前时间
        LocalDate currentDate = LocalDate.now();
        //System.out.println("获取当前时间:" + currentDate);

        // 获取当前时间的年、月、日
        int year = currentDate.getYear();
        int monthValue = currentDate.getMonthValue();
        int dayOfMonth = currentDate.getDayOfMonth();
        //System.out.println("年: " + year +"\n月: "+monthValue+"\n日: "+dayOfMonth);

        // 获取自定义的日期
        LocalDate localDate = LocalDate.of(2019, 07, 2);
        //System.out.println("自定义日期为: " + localDate);

        // 检查两个日期是否相等
        boolean equals = currentDate.equals(localDate);
        //System.out.println("两个日期是否相等: " + equals);

        // 检查重复事件
        MonthDay birthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay day = MonthDay.from(currentDate);
        if (day.equals(birthDay)) {
            //  System.out.println("今天是你的生日");
            //return;
        }
        //System.out.println("对不起,今天不是你的生日");

        // 增加时间里面的小时
        LocalTime localTime = LocalTime.now();
        //System.out.println("当前时间为: " + localTime);
        //LocalTime plusHours = localTime.plusHours(2);
        LocalTime plus = localTime.plus(2, ChronoUnit.MINUTES);
        //System.out.println("两小时后的时间为: " + plus);

        // 获取一周后的日期
        LocalDate nowDate = LocalDate.now();
        //System.out.println("当前的日期为: " + nowDate);
        //LocalDate aWeekLaterDate = nowDate.plus(1, ChronoUnit.MILLIS);
        //System.out.println("一周后的日期为: " + aWeekLaterDate);
        //周(WEEKS) 月(MONTHS) 天(DAYS) 时(HOURS) 分(MINUTES)  秒(SECONDS)

        // 获取一年前后的日期
        LocalDate now = LocalDate.now();
        LocalDate plus1 = now.plus(1, ChronoUnit.YEARS);
        //System.out.println("一年之后的日期为: " + plus1);
        LocalDate minus = now.minus(1, ChronoUnit.YEARS);
        //System.out.println("一年之前的日期为: " + minus);

        //使用时钟
        Clock clock = Clock.systemUTC();
       // System.out.println("获取到的时钟: " + clock);
        Clock.systemDefaultZone();
       // System.out.println("clock = " + clock);

        // 判断某个日期是在另一个日期的前面还是后面
        LocalDate now1 = LocalDate.now();
        LocalDate plus2 = now1.plus(1, ChronoUnit.DAYS);
        //System.out.println("当前日期在另一日期之前: " + now1.isBefore(plus2));
        //System.out.println("当前日期在另一日期之后: " + now1.isAfter(plus2));

        //如何表示固定的日期,比如信用卡过期时间
        YearMonth yearMonth = YearMonth.now();
        //System.out.println("获取现在年份和月份: " + yearMonth+" 当月多少天: "+yearMonth.lengthOfMonth());
        YearMonth month = YearMonth.of(2018, Month.FEBRUARY);
        //System.out.println("自定义设置年月: " + month);

        //检查闰年
        LocalDate now2 = LocalDate.now();
        LocalDate of = LocalDate.of(2004, 1, 2);
        //System.out.println("当前日期: " + of+" 是否闰年: "+of.isLeapYear());

        //两个日期之间包含多少天,多少月
        LocalDate now3 = LocalDate.now();
        LocalDate of1 = LocalDate.of(2019, 5, 25);
        Period between = Period.between(now3, of1);
        //System.out.println("当前日期: " + now3 + " 自定义设置的日期: " + of1 + " 两者相差多少天: " + between.getDays());

        // 获取带时区的日期和时间
       /* LocalDateTime of3 = LocalDateTime.of(2019, 2, 3,10,30,30);
        ZoneOffset of2 = ZoneOffset.of("+05:30");
        OffsetDateTime dateTime = OffsetDateTime.of(of3, of2);*/
        //System.out.println("获取带时区的日期和时间: " + dateTime);

        // 获取当前时间戳
        Instant now4 = Instant.now();
        Date from = Date.from(now4);
        //System.out.println("当前时间戳为: " + from);

        // 改变日期的格式(转为2019-03-15)
        String toDay="2019 03 15";
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
            LocalDate parse = LocalDate.parse(toDay, dateTimeFormatter);
           // System.out.println("转换之前的日期: "+toDay+" 转换之后的日期: " + parse);
        }catch (DateTimeParseException e){
           // System.out.println("日期转换异常: "+toDay);
        }

        // 日期转成字符串
        LocalDateTime now5 = LocalDateTime.now();
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm a");
            String format = now5.format(dateTimeFormatter);
            System.out.println("转换前的日期: " +now5+" 转换为字符串: "+ format);
        }catch (DateTimeParseException e){
            System.out.println("日期转换异常: "+now5);
        }


    }
}
