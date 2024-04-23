package test.异常线程;

/**
 * 生产车间
 *
 * @Author WangXinWei
 * @Date 2022/2/7 19:03
 * @Version 1.0
 */
public class ProductFactory {
    private String name;
    private Double price;
    private Boolean phonse=false;
    // 定义一个默认值
    private int i = 0;

    /**
     * 生产者
     */
    public synchronized void product() {
        if (phonse){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (i % 2 == 0) {
            this.name = "华为";
            this.price = 888.88;
        } else {
            this.name = "苹果";
            this.price = 1000.00;
        }
        i++;
        this.phonse = true;
        this.notify();
    }

    /**
     * 消费者
     */
    public synchronized void get() {
        if (phonse){
            System.out.println("获取到的手机..." + this.name + "价格为..." + this.price);
            this.phonse = false;
            this.notify();
        }else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
