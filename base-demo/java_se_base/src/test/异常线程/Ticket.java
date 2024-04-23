package test.异常线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author WangXinWei
 * @Date 2022/2/7 17:04
 * @Version 1.0
 */
public class Ticket implements Runnable {
    private int ticket = 100;
    // String s = "锁";
    // JDK1.5之后,用Lock锁来代替同步代码块
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
            while (true){
                lock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + ticket);
                    ticket--;
                }
                lock.unlock();
        }
    }
}
