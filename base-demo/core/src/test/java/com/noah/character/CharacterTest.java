package com.noah.character;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.extern.slf4j.Slf4j;

/**
 * 字符类测试
 *
 * @Author: WangXinWei
 * @Date: 2019/12/24 11:20
 * @Version 1.0
 */
@Slf4j
public class CharacterTest {
    public static void main(String[] args) {
        // 原子符装箱到Character对象中
        Character charToCharacter = 'a';
        // System.out.println("原子符装箱到Character对象中 = " + charToCharacter);
        // Character拆箱为基本数据类型char值
        char characterToChar = charToCharacter;
        //System.out.println("Character拆箱为基本数据类型char值 = " + characterToChar);

        /*// 转义序列  \t
        String s="在文中该处插入一个tab键";
        String ss = "配角";
        System.out.println("在文中该处插入一个tab键: "+s+"\t"+ss);*/

        /*// 转义序列  \b
        String s = "插入一个后退键 ";
        String ss = "配角";
        System.out.println("s = " + s+"\b"+ss);*/

        /*// 转义序列 \n
        String s = "换行符";
        String ss = "你好";
        System.out.println("s = " + s+"\n"+ss);*/

        /*// 转义序列  \r
        String s = "回车键";
        String ss = "你好";
        System.out.println("s = " + s+"\n"+ss);*/

        /*// 转义序列  \f
        String s = "换页符";
        String ss = "你好";
        System.out.println("s = " + s+"\f"+ss);*/

        /*// 转义序列   \'
        String s = "单引号";
        String ss = "a";
        System.out.println("s = " + s+"\'"+ss+"\'");*/

        /*// 转义序列  \"
        String s = "双引号";
        String ss = "a";
        System.out.println("ss = " + s+"\""+ss+"\"");*/

        /*// 转义序列
        String s = "反斜杠";
        String ss = "a";
        System.out.println("ss = " + s+"\\"+ss+"\\");*/

        /*// isLetter
        char c = 'a';
        System.out.println("是否是一个字母: " + Character.isLetter(c));*/

        /*// isDigit
        char c = '1';
        System.out.println("是否是一个数字字符： " + Character.isDigit(c));*/

        /*// isWhitespace
        char c='a';
        System.out.println("是否是一个空白字符： " + Character.isWhitespace(c));*/

        /*// isUpperCase
        char c = 'A';
        System.out.println("是否是大写字符： " + Character.isUpperCase(c));*/

        /*// isLowerCase
        char c = 'A';
        System.out.println("是否是小写字符： " + Character.isLowerCase(c));*/

        // toString
        char c = 'c';
        System.out.println("字符转字符串： " + Character.toString(c));
    }
}
