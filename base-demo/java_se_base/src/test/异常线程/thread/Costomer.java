package test.异常线程.thread;

/**
 * @Author WangXinWei
 * @Date 2022/2/18 5:01
 * @Version 1.0
 */
public class Costomer implements Runnable {
    private ProductFortacy pf;
    public int number = 0;

    public Costomer(ProductFortacy pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        while (number<15){
            this.pf.costomer();
            number++;
        }
    }
}
