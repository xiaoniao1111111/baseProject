package test.Object17;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * @Author WangXinWei
 * @Date 2022/1/21 20:26
 * @Version 1.0
 */
public class ObjectTest {
    private static Logger logger = Logger.getLogger(ObjectTest.class);

    public static void main(String[] args) {
        // classToStringTest();
        // classToStringTest02();
        // hashCodeTest();
        // dateToStringTest();
        //  stringToDateTest();
        phaseDayTest();
    }

    /**
     * 类中toSting练习
     */
    public static void classToStringTest() {
        Student student = new Student("小王", "11");
        System.out.println(student.toString());
    }

    /**
     * 扩展: 对象通过.toString()方法打印出来的属性信息是带有对象名的
     * 通过JSONObject.toJSONString()方法则能取消对象名
     */
    public static void classToStringTest02() {
        Student student = new Student("小王", "11");
        System.out.println(JSONObject.toJSONString(student));
    }

    /**
     * 获取对象的哈希码值
     */
    private static void hashCodeTest() {
        Student student = new Student("小花", "11");
        Student student1 = new Student("小花", "11");
        int i = student.hashCode();
        System.out.println("student = " + i);
        int i1 = student1.hashCode();
        System.out.println("student1 = " + i1);
    }

    /**
     * 日期转字符串
     */
    private static void dateToStringTest() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        System.out.println("日期转字符串: " + format);
    }

    /**
     * 字符串转换成日期
     */
    private static void stringToDateTest() {
        String s = new Scanner(System.in).nextLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(s);
            String format = dateFormat.format(date);
            System.out.println(format);
        } catch (Exception e) {
            logger.error("日期转换异常,异常信息为:", e);
        }
    }

    /**
     * 计算: 从现在到出生多少天
     */
    private static void phaseDayTest() {
        String s = new Scanner(System.in).nextLine();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long startTime = dateFormat.parse(s).getTime();
            long endTime = new Date().getTime();
            System.out.println("已有: " + (endTime - startTime) / 1000 / 60 / 60 / 24 / 365 + "年");
        } catch (Exception e) {
            logger.error("日期转换异常,异常信息为:", e);
        }
    }


}
