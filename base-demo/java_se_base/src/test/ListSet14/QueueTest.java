package test.ListSet14;

/**
 * @Author WangXinWei
 * @Date 2022/2/5 10:54
 * @Version 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        queue_01();
    }

    /**
     * 模拟队列数据结构
     */
    private static void queue_01() {
        Queue<Integer> queue = new Queue<>();
        queue.addData(111);
        queue.addData(222);
        queue.addData(333);
        Integer data = queue.getData();
        System.out.println("1: " + data);
        while (!queue.isEmplty()) {
            queue.deleteData();
        }
    }
}
