package test.类对象06;

public class Extends {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setEye("蓝眼睛");
        cat.setName("猫");
        cat.setMonth("小嘴巴");
        System.out.println("cat = " +cat.getName()+cat.getMonth()+cat.getEye());
    }
}
