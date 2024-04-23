package test.类对象06.array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int middle = 0;
        for (int min = 0, max = arr.length - 1; min < max; min++, max--) {
            middle = arr[max];
            if (arr[min] <= arr[max]) {
                arr[max] = arr[min];
            }
            arr[min] = middle;
        }
        System.out.println("反转后的数组为: " + Arrays.toString(arr));
    }
}
