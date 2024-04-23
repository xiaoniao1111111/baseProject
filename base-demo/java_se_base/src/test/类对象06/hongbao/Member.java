package test.类对象06.hongbao;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.List;
import java.util.Random;

public class Member extends User {
    public Member(String name, Double leftMoney) {
        super(name, leftMoney);
    }

    public void qiangHongBao(List<Double> moneys) {
        if (CollectionUtils.isEmpty(moneys)) {
            System.out.println("亲,手太慢了,红包已经抢完了");
        }
        Random random = new Random();
        int index = random.nextInt(moneys.size());
        Double money = moneys.remove(index);
        Double leftMoney = this.getLeftMoney();
        leftMoney += money;
        this.setLeftMoney(leftMoney);
    }
}
