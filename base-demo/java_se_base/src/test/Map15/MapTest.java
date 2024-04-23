package test.Map15;


import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Map练习
 *
 * @Author WangXinWei
 * @Date 2021/5/6 20:23
 * @Version 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        // Map常用方法演练
        // map_01();
        // LinkedHashMap演练
        linkedHashMapTest();
        // 键盘录入一个字符串,判断字符串中的每个字符存在的次数
        charCountTest();
    }

    private static void charCountTest() {
        // 1.创建键盘录入对象
        // 2. 获取录入的值
        // 3. 创建map对象,key保存字符,value保存次数
        // 4. 遍历字符串,取出每一个字符
        /**
         * 5. 取出的字符与map中的key判断是否存在该字符,
         *     存在: 获取value并+1,不存在: 存入字符,默认value为1,最终将结果存入map中
         */
        // 6.遍历Map
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                value += 1;
                map.put(c, value);
            } else {
                map.put(c, 1);
            }
        }
        map.entrySet().forEach(System.out::println);
    }

    /**
     * LinkedHashMap演练
     */
    private static void linkedHashMapTest() {
        // LinkedHashMap 演练
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("4", "g");
        map.put("5", "h");
        System.out.println(map);
    }

    /**
     * Map常用方法演练
     */
    private static void map_01() {
        Map<String, Object> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        // 1.获取所有的key
        map.keySet().forEach(System.out::println);
        // 2. 获取所有的value
        map.values().forEach(System.out::println);
        // 3. 判断集合是否为空
        boolean empty = map.isEmpty();
        System.out.println("判断集合是否为空： " + empty);
        // 4. 获取key对应value Set集合
        map.entrySet().forEach(item -> System.out.println("key对应value: " + item.getKey() + "-----" + item.getValue()));
        // 5. 判读key中是否包含该元素
        boolean b = map.containsKey("1");
        System.out.println("判读key中是否包含该元素: " + b);
        // 6. 判断value是否包含该元素
        boolean b1 = map.containsValue("b");
        System.out.println("判断value是否包含该元素: " + b1);
        // 7. 删除该key对应的键值对
        Object remove = map.remove("1");
        System.out.println("删除该key对应的键值对 " + map);
        // 8. 获取map的长度
        int size = map.size();
        System.out.println("获取map的长度: " + size);
        // 9. map的key可以为null,但只能存在一个null
        map.put(null, "aa");
        System.out.println(map);
    }
}
