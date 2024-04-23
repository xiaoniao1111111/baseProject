package com.noah.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 *
 * @Author: WangXinWei
 * @Date: 2019/12/24 10:42
 * @Version 1.0
 */
public class RegexTest {
    public static void main(String[] args) {
        /*// 该字符串中是否包含"runoob"
        String content = "I am noob" + "from runoob.com";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("该字符串中是否包含\"runoob\": " + isMatch);*/

        // 捕获组测试  按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 创建pattern对象
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(line);
        if (matcher.find()){
            System.out.println("整个表达式：" + matcher.group(0));
            System.out.println("分组1结果： " + matcher.group(1));
            System.out.println("分组2结果： " + matcher.group(2));
            System.out.println("分组3结果： " + matcher.group(3));
        }else {
            System.out.println("no match");
        }
    }
}
