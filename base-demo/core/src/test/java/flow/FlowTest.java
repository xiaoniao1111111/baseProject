package flow;

import java.util.Arrays;
import java.util.List;

public class FlowTest {
    public static void main(String[] args) {
        int median = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        for (int min = 0, max = arr.length - 1; min < max; min++, max--) {
            median = arr[max];
            if (arr[min] <= arr[max]) {
                arr[max] = arr[min];
            }
            arr[min] = median;
        }
        System.out.println("反转后的数组为: " + Arrays.toString(arr));
    }
}
