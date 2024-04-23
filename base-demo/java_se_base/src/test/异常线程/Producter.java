package test.异常线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author WangXinWei
 * @Date 2022/2/7 19:08
 * @Version 1.0
 */
public class Producter implements Runnable{
    private ProductFactory pf;

    public Producter(ProductFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pf.product();
        }
    }
}
