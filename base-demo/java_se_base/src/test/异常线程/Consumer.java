package test.异常线程;

/**
 * 消费者,消费手机
 *
 * @Author WangXinWei
 * @Date 2022/2/7 19:09
 * @Version 1.0
 */
public class Consumer implements Runnable {
    private ProductFactory pf;

    public Consumer(ProductFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pf.get();
        }
    }
}
