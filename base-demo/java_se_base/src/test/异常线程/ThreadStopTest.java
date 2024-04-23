package test.异常线程;

import com.alibaba.druid.util.StringUtils;

/**
 * @Author: WangXinWei
 * @Date: 2023/05/08/11:24
 * @Description:
 */
public class ThreadStopTest {
    public static User user = new User();
    public static class ChangeObject extends Thread {
        @Override
        public void run() {
            int v = (int) System.currentTimeMillis();
            while (true) {
                synchronized (user) {
                    user.setId(v);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    public static class RandObject extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (user){
                    String name = user.getName();
                    if (!StringUtils.isEmpty(name)&&user.getId()!=Integer.parseInt(user.getName())){
                        System.out.println(user.getId()+"------"+user.getName());
                    }
                }
                Thread.yield();

            }
        }
    }



    public static void main(String[] args) {
        RandObject randObject = new RandObject();
        randObject.start();

        while (true){
            ChangeObject changeObject = new ChangeObject();
            changeObject.start();
            try {
                Thread.sleep(150);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            changeObject.stop();
        }


    }
}
