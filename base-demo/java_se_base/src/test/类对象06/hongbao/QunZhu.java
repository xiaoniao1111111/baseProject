package test.类对象06.hongbao;

import java.util.ArrayList;
import java.util.List;

public class QunZhu extends User {

    public QunZhu(String name, Double leftMoney) {
        super(name, leftMoney);
    }

    /**
     * 群主发红包
     *
     * @param money 单个红包金额
     * @param count 红包个数
     * @return 返回红包集合
     */
    public List<Double> sendHongBao(double money, int count) {
        List<Double> list = new ArrayList<>();
        Double leftMoney = this.getLeftMoney();
        if (leftMoney < money * count) {
            System.out.println("亲,您的余额不足");
        }
        leftMoney -= money * count;
        this.setLeftMoney(leftMoney);
        for (int i = 0; i < count; i++) {
            list.add(money);
        }
        return list;
    }


}
