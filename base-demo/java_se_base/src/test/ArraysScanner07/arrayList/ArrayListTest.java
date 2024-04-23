package test.ArraysScanner07.arrayList;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        List<String> strings = Arrays.asList(arr);
        strings.forEach(System.out::print);
    }
}
