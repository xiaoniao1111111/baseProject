package test.动态代理.proxybak;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 10:14
 * @Version 1.0
 */
public class XiaoWang implements Fuit {
    @Override
    public void applePrice(Double price) {
        System.out.println("苹果数量为: " + price);
    }

    @Override
    public void bananaPrice(Double price) {
        System.out.println("香蕉数量为: " + price);
    }

    @Override
    public void pearPrice(Double price) {
        System.out.println("梨的数量为: " + price);
    }
}
