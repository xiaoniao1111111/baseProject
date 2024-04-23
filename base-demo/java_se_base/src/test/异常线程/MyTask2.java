package test.异常线程;

/**
 * @Author WangXinWei
 * @Date 2022/2/9 20:22
 * @Version 1.0
 */
public class MyTask2 implements Runnable {
    @Override
    public void run() {
        System.out.println("创建线程方式二...");
    }
}
