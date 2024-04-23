package test.异常线程;

/**
 * @Author WangXinWei
 * @Date 2022/2/7 16:28
 * @Version 1.0
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"-----"+i);
        }
    }
}
