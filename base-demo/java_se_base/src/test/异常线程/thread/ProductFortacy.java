package test.异常线程.thread;

/**
 * 生产车间
 *
 * @Author WangXinWei
 * @Date 2022/2/18 4:45
 * @Version 1.0
 */
public class ProductFortacy {
    private String name;
    private Double price;
    private Boolean isphonse=false;
    private Integer num=0;

    /**
     * 生产者生产手机
     */
    public synchronized void getProduct() {
        // 1. 判断是否有手机,有等待,没有则生产手机
        if (isphonse){
            // 有手机
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 没有手机,生产手机(2. 奇数生产小米,偶数生产华为)
        if (num%2==0){
            this.name = "华为";
            this.price = 6.66;
        }else {
            this.name = "小米";
            this.price = 1.11;
        }
        // 3. 生产完手机之后改变手机状态,同时唤醒消费者消费手机
        this.isphonse = true;
        this.notify();
        this.num++;
    }

    /**
     * 消费者消费手机
     */
    public synchronized void costomer() {
        // 1. 没有手机则进入等待
        if (!isphonse){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 2. 有手机则消费手机,同时唤醒生产者生产手机
        System.out.println(Thread.currentThread().getName() + ": " + this.name + "===" + this.price);
        this.isphonse = false;
        try {
            this.notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
