package com.noah.string;


public class StringTest {
    public static void main(String[] args) {
        // 字符串拼接测试
        // concatTest();
        // 字符串是否包含方法测试
        //containsTest();
        // 检测该字符串是否以指定前缀开始
        startsWithTest();

    }

    private static void startsWithTest() {
        String s = "aa";
        boolean flag = s.startsWith("a");
        System.out.println("该字符串是否以a字符前缀开始: "+flag);
    }

    private static void containsTest() {
        String s = "aa";
        boolean flag = s.startsWith("a");
        System.out.println("该字符串是否以a字符前缀开始: "+flag);
    }

    private static void concatTest() {
        // 实现字符串拼接: [1#2#3]
        String concat = null;
        String[] strs = {"1", "2", "3"};
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            // 如果是第一次则要加左中括号
            if (0 == i) {
                concat = "[" + strs[i];
            } else {
                // 不是第一次也不是最后一次,中间拼接用#连接
                if (i < length - 1) {
                    concat = concat.concat("#") + strs[i];
                } else {
                    // 如果是最后一次则用右中括号拼接
                    concat = concat.concat("#") + strs[i] + "]";
                }
            }
        }
        System.out.println(concat);
    }
}
