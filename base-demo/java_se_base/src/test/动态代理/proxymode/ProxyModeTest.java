package test.动态代理.proxymode;

/**
 * 静态代理测试
 *
 * @Author WangXinWei
 * @Date 2022/3/7 20:31
 * @Version 1.0
 */
public class ProxyModeTest {
    public static void main(String[] args) {
        WangWu wangWu = new WangWu();
        wangWu.saving(2000.00);
        wangWu.liveShow(1000.00);
        wangWu.sleep();
    }
}
