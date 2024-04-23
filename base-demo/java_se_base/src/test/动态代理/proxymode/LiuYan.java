package test.动态代理.proxymode;

/**
 * 被代理对象
 *
 * @Author WangXinWei
 * @Date 2022/3/7 20:24
 * @Version 1.0
 */
public class LiuYan implements Star {

    @Override
    public void saving(Double money) {
        System.out.println("唱了一首真的爱你....");
        System.out.println("赚了" + money + "块....");

    }

    @Override
    public void liveShow(Double money) {
        System.out.println("参加了爱情堡垒...");
        System.out.println("赚了" + money + "块....");
    }

    @Override
    public void sleep() {
        System.out.println("柳岩休息一会...");
    }
}
