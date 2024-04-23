package test.类对象06;

/**
 * @Author: WangXinWei
        * @Date: 2019/6/27 15:52
        * @Version 1.0
        */
public class VaribleTest {
    public  VaribleTest(String name){
        System.out.println("name = " + name);
    }
    public static void main(String[] args) {
        VaribleTest varibleTest = new VaribleTest("小王");
    }
}
