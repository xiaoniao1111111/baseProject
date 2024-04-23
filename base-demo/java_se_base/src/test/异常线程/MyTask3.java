package test.异常线程;

/**
 * @Author WangXinWei
 * @Date 2022/2/9 22:05
 * @Version 1.0
 */
public class MyTask3 implements Runnable {
    private int tacks = 100;
   private Object b = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (b){
                if (tacks>0){
                    System.out.println(Thread.currentThread().getName() +"..."+ tacks);
                    tacks--;
                }
            }

        }
    }
}
