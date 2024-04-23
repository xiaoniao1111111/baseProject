package test.异常线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author WangXinWei
 * @Date 2022/2/7 15:43
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 创建线程类方式一
        //threadTest_01();
        // 创建线程类方式二
        //threadTest_02();
        // 多线程安全问题演示
        //threadTest_03();
        // 线程通信演练
       // thread_04();
        ExecutorService es = Executors.newFixedThreadPool(3);
        MyTask3 mt = new MyTask3();
        Lock lock = new ReentrantLock();
        es.execute(mt);
        es.execute(mt);
        es.execute(mt);
    }

    private static void thread_04() {
        ProductFactory pf = new ProductFactory();
        // 生产者生产手机
        Producter producter = new Producter(pf);
        Thread thread = new Thread(producter, "生产者");
        thread.start();
        // 消费者消费手机
        Consumer consumer = new Consumer(pf);
        Thread thread1 = new Thread(consumer, "消费者");
        thread1.start();
    }

    private static void threadTest_03() {
        Ticket task = new Ticket();
        Thread thread1 = new Thread(task, "窗口1");
        Thread thread2 = new Thread(task, "窗口2");
        Thread thread3 = new Thread(task, "窗口3");
        Thread thread4 = new Thread(task, "窗口4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static void threadTest_02() {
        // 参数一: 任务类对象   参数二: 线程名字
        Thread thread = new Thread(new MyTask(),"创建线程类方式二");
        thread.start();
    }

    private static void threadTest_01() {
        MeThread thread = new MeThread();
        thread.setName("aaa");
        MeThread thread1 = new MeThread();
        thread1.setName("bbb");
        thread.start();
        thread1.start();
    }
}
