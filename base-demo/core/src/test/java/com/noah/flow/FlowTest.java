package com.noah.flow;

import java.util.Arrays;
import java.util.List;

public class FlowTest {
    public static void main(String[] args) {
        // continue测试
        continueTest();
    }

    private static void continueTest() {
        // 下列集合,奇数求和
        int sum = 0;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i < list.size(); i++) {
            if (0 == list.get(i) % 2) {
                continue;
            }
            sum += list.get(i);
        }
        System.out.println("以上集合所有奇数的和为: " + sum);
    }
}
