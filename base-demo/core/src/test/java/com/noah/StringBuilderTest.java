package com.noah;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WangXinWei
 * @Date: 2019/6/3 11:08
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class StringBuilderTest {
    @Test
    public void stringCapacityTest() {
        //设置该字符串的容量和长度
        StringBuilder stringBuilder = new StringBuilder(2);
        //往stringBuilder中添加字符串
        stringBuilder.append("hell0");
        System.out.println("stringBuilder :" + stringBuilder);
        //查看该字符串的容量
        int capacity = stringBuilder.capacity();
        System.out.println("该字符串的容量为 :" + capacity);
    }

    @Test
    public void stringBuilderAppendTest() {
        StringBuilder stringBuilder = new StringBuilder("hello");
        stringBuilder.append("WangXinWei");
        System.out.println("添加了'WangXinWei'字段后该字符串为 :" + stringBuilder);
    }

    @Test
    public void stringBuilderInsertTest() {
        StringBuilder stringBuilder = new StringBuilder("xinshui");
        stringBuilder.insert(3, "de");
        System.out.println("stringBuilder中第3个字符位置后添加'de'后的字符为: " + stringBuilder);
    }

    @Test
    public void stringBuilderRemoveTest() {
        StringBuilder stringBuilder = new StringBuilder("hello nihao");
        stringBuilder.replace(2, 5, "2");
        System.out.println("stringBuilder = " + stringBuilder);
    }
}
