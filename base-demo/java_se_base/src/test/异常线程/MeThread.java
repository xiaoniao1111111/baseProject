package test.异常线程;

/**
 * @Author WangXinWei
 * @Date 2022/2/7 15:43
 * @Version 1.0
 */
public class MeThread extends Thread {
    /*   1. 自定义线程类继承Thread,这个类就叫线程类
         2. 复写Thread类中的run()方法,run方法中用来书写具体的业务
         3. 在main方法中创建自定义线程类,
         4. 调用start()方法,启动线程
    */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
