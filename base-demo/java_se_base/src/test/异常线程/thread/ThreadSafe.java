package test.异常线程.thread;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 4:24
 * @Version 1.0
 */
public class ThreadSafe implements Runnable {
    private int piao = 100;

    @Override
    public void run() {
        while (true){
            safe();
        }
    }

    private synchronized void safe() {
        if (piao>0){
            System.out.println(Thread.currentThread().getName() + ": " + piao);
            piao--;
        }
    }
}
