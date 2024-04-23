package stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK1.8(Java8)--stream
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 11:31
 * @Version 1.0
 */
public class StreamTest {
    @Test
    public void testByStream() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
    }

    /**
     * 集合中有一个匹配,则返回true
     */
    @Test
    public void anyMatch() {
        // anyMatch
        boolean b = Arrays.asList("a", "b", "c", "d").contains("a");
        System.out.println("b = " + b);
    }

    /**
     * 对象中的某个字段分组作为key,获取分组集合中某个元素的集合
     */
    @Test
    public void mappingtTest() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
        // mapping
        users.add(new User("王五", "男", "玩"));
        Map<String, List<String>> userNameAndUserLike = users.stream()
                .collect(Collectors.groupingBy(User::getUserName,
                        Collectors.mapping(User::getLike, Collectors.toList())));
        userNameAndUserLike.forEach((userName, userLikes) -> {
            System.out.println("userName = " + userName + " userLikes" + userLikes);
        });
    }

    /**
     * 将数据类型转换成String
     */
    @Test
    public void toStringTest() {
        // Object::toString
        Stream.of(2, 3, 4, 5, 6, 7).map(Objects::toString)
                .collect(Collectors.toList())
                .forEach(System.out::print);
    }

    /**
     * 如果原数据为空,则返回orElse设置的值
     */
    @Test
    public void orElse() {
        // orElse
        String filterString = Stream.of("a", "b", "c", "d")
                .min(Comparator.comparing(String::valueOf))
                .filter(item -> item.equals("cc"))
                .orElse("其他");
        System.out.println("最终结果为: " + filterString);
    }

    /**
     * 取前几条数据
     */
    @Test
    public void limit() {
        // limit
        Stream.of("a", "b", "c", "c", "e").limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 跳过前几条数据
     */
    @Test
    public void sikp() {
        // sikp
        Stream.of("a", "b", "c", "e").skip(2)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 过滤掉为null的元素
     */
    @Test
    public void objectNonNull() {
        // Objects::nonNull
        Stream.of("a", null, "cc", "dd", "exe")
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 取最小值
     */
    @Test
    public void min() {
        // min
        Integer integer = Stream.of(2, 3, 45, 66, 2, 4, 54, 23).min(Comparator.comparing(Integer::intValue)).get();
        System.out.println("求最小值: " + integer);
    }

    /**
     * 取最大值
     */
    @Test
    public void max() {
        // max
        Integer integer = Stream.of(3, 4, 12, 23, 45, 122).max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("求最大值: " + integer);
    }

    /**
     * 元素求和
     */
    @Test
    public void reduce() {
        Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum);
        System.out.println("累计求和: " + reduce);
    }

    /**
     * 返回对象中的属性一一对应map
     */
    @Test
    public void toMap() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
        Map<String, String> userNameAndUserLikeMap = users.stream().collect(Collectors.toMap(User::getUserName, User::getLike));
        userNameAndUserLikeMap.forEach((userName, userLike) -> {
            System.out.println("userName: " + userName + " userLike" + userLike);
        });
    }

    /**
     * 分组
     */
    @Test
    public void groupingBy() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
        Map<String, List<User>> userNameAndUserMap = users.stream().
                collect(Collectors.groupingBy(User::getUserName));
        userNameAndUserMap.forEach((userName, userList) -> {
            System.out.println("用户名称: " + userName + " 用户: " + userList.get(0));
        });
    }

    /**
     * 如果有空或者null元素则放在首位
     */
    @Test
    public void nullsFirst() {
        Stream.of("a", "b", "c", "", "e")
                .sorted(Comparator.nullsFirst(Comparator.comparing(String::valueOf)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 多个参数排序时使用
     */
    @Test
    public void thenComparing() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
        users.stream().sorted(Comparator.comparing(User::getUserName)
                .thenComparing(User::getSex))
                .collect(Collectors.toList())
                .forEach(item -> System.out.println("item = " + item));
    }

    /**
     * 遍历
     */
    @Test
    public void foreach() {
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);
    }

    /**
     * 升序排序
     */
    @Test
    public void sortedByAsc() {
        Stream.of("ff", "bb", "cc", "ee", "gg")
                .sorted(Comparator.comparing(String::valueOf))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 降序排序
     */
    @Test
    public void sortedByReversed() {
        Stream.of("dd", "aa", "bb", "ee", "cc")
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 去重
     */
    @Test
    public void distinct() {
        List<String> distinctListByAa = Stream.of("aa", "bb", "cc", "aa", "ee")
                .distinct()
                .collect(Collectors.toList());
        distinctListByAa.forEach(System.out::println);
    }

    /**
     * map带有返回结果集
     */
    @Test
    public void map() {
        List<User> users = new ArrayList<>();
        users.add(new User("王五", "男", "睡觉"));
        users.add(new User("李四", "男", "看书"));
        users.add(new User("小花", "女", "听音乐"));
        users.add(new User("张三", "男", "打篮球"));
        List<String> userNames = users.stream().map(User::getUserName).collect(Collectors.toList());
        userNames.forEach(System.out::println);
    }

    /**
     * 过滤
     */
    @Test
    public void filter() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream()
                .filter("aa"::equals)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 不可变集合: list
     */
    @Test
    public void finalList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.add(1);

    }

    /**
     * 不可变集合: set
     */
    @Test
    public void finalSet() {
        Set<String> set = Set.of("张三", "李四", "王五 ");
        set.add("lll");
        finalMap();
    }

    /**
     * 不可变集合: map
     */
    @Test
    public void finalMap() {
        Map<Integer, String> map = Map.of(1, "张三", 2, "李四", 3, "王五");
        map.put(4, "333");
    }

    /**
     * 不可变集合map,添加更多的元素
     */
    @Test
    public void finalManyMap() {
        Map<Integer, String> manyMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            manyMap.put(i, "111");
        }
        Map<String, String> map = new HashMap<>();

    }

    static List<User> getUserList() {
        User user = new User("张三", "男", "吃饭");
        User user1 = new User("李四", "女", "睡觉");
        User user2 = new User("王五", "男", "打游戏");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        return list;
    }

    static List<Integer> getIntegerList() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
    }

    static Set<Integer> getIntegerSet() {
        return Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet());
    }

    @Test
    public void method() {
        List<User> userList = getUserList();
        Map<String, String> nameAndLikeMap = userList.stream().collect(Collectors.toMap(User::getUserName, User::getLike));
        nameAndLikeMap.forEach((key, value) -> System.out.println(key + "================" + value));
    }

    /**
     * 返回set
     */
    @Test
    public void returnSet() {
        Set<Integer> set = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toSet());
        set.forEach(System.out::print);
    }

    /**
     * 返回集合
     */
    @Test
    public void returnList() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        list.forEach(System.out::print);
    }


    @Test
    public void sortByAsc() {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void sortByDesc() {
        List<User> userList = getUserList();
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
    }
}
