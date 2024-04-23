package test.异常线程.thread;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 4:20
 * @Version 1.0
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": 创建线程方式二");
    }
}
