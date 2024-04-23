package test.动态代理.proxymode;

/**
 * 代理对象
 *
 * @Author WangXinWei
 * @Date 2022/3/7 20:26
 * @Version 1.0
 */
public class WangWu implements Star {
    LiuYan liuYan = new LiuYan();

    @Override
    public void saving(Double money) {
        if (money<2000){
            System.out.println("钱太少,拒绝...");
            return;
        }
        System.out.println("唱歌:王五抽取了" + money * 0.2 + "元...");
        liuYan.saving(money * 0.8);
    }

    @Override
    public void liveShow(Double money) {
        if (money<3000){
            System.out.println("钱太少,拒绝...");
            return;
        }
        System.out.println("参加真人秀:王五抽取了" + money * 0.2 + "元...");
        liuYan.saving(money * 0.8);
    }

    @Override
    public void sleep() {
        liuYan.sleep();
    }
}
