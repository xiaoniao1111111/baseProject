package test.ListSet14;

import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;


/**
 * LinkedList方法演示
 *
 * @Author WangXinWei
 * @Date 2021/4/24 10:44
 * @Version 1.0
 */
@Slf4j
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        addFistTest(strings);
        addLastTest(strings);
        // 获取该集合第一个元素
        String first = strings.getFirst();
        // 获取该集合最后一个元素
        String last = strings.getLast();
        // 移除该集合中第一个元素并返回该元素
        String removeFirst = strings.removeFirst();
        // 移除该集合中最后一个元素并返回该元素
        String removeLast = strings.removeLast();
        
    }

    /**
     * 指定元素添加到集合结尾
     *
     * @param strings
     */
    private static void addLastTest(LinkedList<String> strings) {
        strings.addLast("b");
        System.out.println(JSONObject.toJSONString(strings));
    }

    /**
     * 指定元素插入到开头
     *
     * @param strings
     */
    private static void addFistTest(LinkedList<String> strings) {
        strings.addFirst("a");
        System.out.println(JSONObject.toJSONString(strings));
    }
}
