package test.类对象06.extend;

public class CatZi extends ZooFu {
    int num = 3;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void show() {
        System.out.println("我是子类的方法");
    }

    @Override
    public void ZooFu() {

    }
}
