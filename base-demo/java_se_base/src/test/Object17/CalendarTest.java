package test.Object17;

import test.final权限内部类10.C;

import java.util.Calendar;

/**
 * @Author WangXinWei
 * @Date 2022/1/21 22:30
 * @Version 1.0
 */
public class CalendarTest {
    public static void main(String[] args) {
        calendarGet();
        calendarSet();
        calendarAdd();
    }

    /**
     * get方法
     */
    private static void calendarGet() {
        Calendar instance = Calendar.getInstance();
        // 获取年
        int year = instance.get(Calendar.YEAR);
        // 获取月
        int month = instance.get(Calendar.MONTH);
        // 获取日
        int day = instance.get(Calendar.DAY_OF_MONTH);
        // 获取时
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        // 获取分
        int minute = instance.get(Calendar.MINUTE);
        // 获取秒
        int second = instance.get(Calendar.SECOND);
        // 获取毫秒
        int millisecond = instance.get(Calendar.MILLISECOND);
        System.out.println("年" + year + "月" + month + "日" + day + "时" + hour + "分" + minute + "秒" + second);
    }

    /**
     * set方法
     */
    private static void calendarSet() {
        Calendar instance = Calendar.getInstance();
        // 设置年
        instance.set(Calendar.YEAR, 2012);
        // 设置月
        instance.set(Calendar.MONTH, 2);
        // 设置日
        instance.set(Calendar.DAY_OF_MONTH, 1);
        // 设置时
        instance.set(Calendar.HOUR_OF_DAY, 10);
        // 设置分
        instance.set(Calendar.MINUTE, 11);
        // 设置秒
        instance.set(Calendar.SECOND, 12);
        // 获取年
        int year = instance.get(Calendar.YEAR);
        // 获取月
        int month = instance.get(Calendar.MONTH);
        // 获取日
        int day = instance.get(Calendar.DAY_OF_MONTH);
        // 获取时
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        // 获取分
        int minute = instance.get(Calendar.MINUTE);
        // 获取秒
        int second = instance.get(Calendar.SECOND);
        // 获取毫秒
        int millisecond = instance.get(Calendar.MILLISECOND);
        System.out.println("年" + year + "月" + month + "日" + day + "时" + hour + "分" + minute + "秒" + second);
    }

    /**
     * add方法
     */
    private static void calendarAdd() {
        Calendar instance = Calendar.getInstance();
        // 年+1
        instance.add(Calendar.YEAR, 1);
        // 月+2
        instance.add(Calendar.MONTH, 1);
        // 日-1
        instance.add(Calendar.DAY_OF_MONTH, -1);
        // 时
        instance.add(Calendar.HOUR_OF_DAY, 1);
        // 分
        instance.add(Calendar.MINUTE, 1);
        // 秒
        instance.add(Calendar.SECOND, 1);
        // 获取年
        int year = instance.get(Calendar.YEAR);
        // 获取月
        int month = instance.get(Calendar.MONTH);
        // 获取日
        int day = instance.get(Calendar.DAY_OF_MONTH);
        // 获取时
        int hour = instance.get(Calendar.HOUR_OF_DAY);
        // 获取分
        int minute = instance.get(Calendar.MINUTE);
        // 获取秒
        int second = instance.get(Calendar.SECOND);
        // 获取毫秒
        int millisecond = instance.get(Calendar.MILLISECOND);
        System.out.println("年" + year + "月" + month + "日" + day + "时" + hour + "分" + minute + "秒" + second);
    }
}
