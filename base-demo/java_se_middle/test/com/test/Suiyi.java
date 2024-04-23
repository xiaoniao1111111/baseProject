package com.test;

import java.util.Arrays;

public class Suiyi {
    public static void main(String[] args) {
        int[] i = {5, 2, 3, 1};
        int asInt = Arrays.stream(i).min().getAsInt();
        System.out.println(asInt);
        int min = 0;
        for (int i1 = 0; i1 < i.length; i1++) {
            int i2 = i[i1];
            if (i1 == 0) {
                min = i2;
            } else {
                if (min > i2) {
                    min = i2;
                }
            }

        }
        System.out.println(min);
    }
}
