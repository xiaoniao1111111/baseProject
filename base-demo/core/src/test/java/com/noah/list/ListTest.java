package com.noah.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // 集合排序-升序排序
        List<String> list = Arrays.asList("1", "7", "5", "3", "9");
       /* list.sort(Comparator.comparing(String::valueOf));
        list.forEach(System.out::print);*/
        // 集合排序-降序排序
      /*  list.sort(Comparator.comparing(String::valueOf).reversed());
        list.forEach(System.out::print);*/
    }
}
