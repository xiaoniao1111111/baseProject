package test.ListSet14;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author WangXinWei
 * @Date 2022/2/5 10:54
 * @Version 1.0
 */
public class Queue<E> {
    LinkedList<E> coll = new LinkedList<E>();
    // 第一步: 往集合中添加元素
    public void addData(E e) {
        coll.add(e);
    }

    // 第二步: 获取集合中的元素
    public E getData() {
        return coll.getFirst();
    }

    // 第三步: 删除集合中的元素
    public E deleteData() {
        return coll.removeFirst();

    }

    // 第四步: 判断集合中的元素是否为空
    public boolean isEmplty() {
        return coll.isEmpty();
    }

}
