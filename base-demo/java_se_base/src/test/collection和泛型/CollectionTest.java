package test.collection和泛型;

import java.util.*;

/**
 * @Author WangXinWei
 * @Date 2022/1/22 1:25
 * @Version 1.0
 */
public class CollectionTest {
    public static void main(String[] args) {
      /*  buildTest();
        buildTest01();*/
        //   parseTest();
        //    iterator();
        //  coll1();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入名字: ");
        String next = scanner.next();
        System.out.println("您输入的名字为: "+ next);
    }

    /**
     * 泛型通配符,泛型上限,下限演练
     */
    private static void coll1() {
        List<String> strings = Arrays.asList("1", "2", "3");
        List<Integer> integers = Arrays.asList(1, 32, 3);
        coll(strings);
        coll(integers);
    }


    private static void coll(Collection<? extends Object> collection) {

    }

    private static void iterator() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add(null);
        strings.add("3");
        Iterator<String> iterator = strings.iterator();
        // 方式一: while迭代
  /*      while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next = " + next);

        }*/
        // 方式二: for循环
        for (strings.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            System.out.println("next1 = " + next);
        }
    }

    /**
     * 装箱与拆箱演示
     */
    private static void buildTest() {
        int i = 1;
        // 装箱
        Integer integer = Integer.valueOf(i);
        System.out.println("装箱 =" + integer);
        // 拆箱
        int i1 = integer.intValue();
        System.out.println("拆箱 = " + i1);
    }

    /**
     * 自动装箱与拆箱
     */
    private static void buildTest01() {
        char r = 'a';
        Character s = r;
        System.out.println("s = " + s);
        char y = s;
        System.out.println("y = " + y);
    }

    private static void parseTest() {
        int i = 1;
        String s = String.valueOf(i);
        int i1 = Integer.parseInt(s);
        System.out.println("i1 = " + i1);
        double b = 1L;
        String s1 = String.valueOf(b);
        double v = Double.parseDouble(s1);
        System.out.println("v = " + v);
    }
}
