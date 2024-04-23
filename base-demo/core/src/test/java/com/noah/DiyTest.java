package com.noah;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiyTest {
    public static void main(String[] args) {
        // ++
        int i = 1;
        i++;
        System.out.println("++ 最终结果为: " + i);
        // --
        int b = 3;
        b--;
        System.out.println("-- 最终结果为:  " + b);
    }
}
