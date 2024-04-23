package test.异常线程.thread;

import test.异常线程.ProductFactory;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 4:19
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        //thread_01();
        //thread_02();
       // threadSafe();
        ProductFortacy pf = new ProductFortacy();
        Thread productThread = new Thread(new Product(pf));
        productThread.start();
        Thread costomerThread = new Thread(new Costomer(pf));
        costomerThread.start();
    }

    private static void threadSafe() {
        ThreadSafe task = new ThreadSafe();
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void thread_02() {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
    }

    private static void thread_01() {
        MyThread myThread = new MyThread();
        myThread.setName("线程方式一");
        myThread.start();
    }
}
