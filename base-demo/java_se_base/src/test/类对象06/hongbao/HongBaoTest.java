package test.类对象06.hongbao;

import java.util.List;

public class HongBaoTest {
    public static void main(String[] args) {
        Double b = 200.00;
        QunZhu qunZhu = new QunZhu("群主", 200.00);
        Member member = new Member("小花",20.00);
        Member member1 = new Member("小方",50.00);
        Member member2 = new Member("小王",80.00);
        List<Double> moneys = qunZhu.sendHongBao(20, 3);
        member.qiangHongBao(moneys);
        member1.qiangHongBao(moneys);
        member2.qiangHongBao(moneys);
        System.out.println("当前"+qunZhu.getName()+"的余额为: "+qunZhu.getLeftMoney());
        System.out.println("当前"+member.getName()+"的余额为: "+member.getLeftMoney());
        System.out.println("当前"+member1.getName()+"的余额为: "+member1.getLeftMoney());
        System.out.println("当前"+member2.getName()+"的余额为: "+member2.getLeftMoney());
    }
}
