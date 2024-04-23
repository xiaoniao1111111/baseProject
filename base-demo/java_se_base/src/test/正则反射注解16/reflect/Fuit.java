package test.正则反射注解16.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @Author WangXinWei
 * @Date 2021/5/11 21:05
 * @Version 1.0
 */
@Data
public class Fuit {
    private String name;
    private String price;

    public Fuit() {
    }

    public Fuit(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public void save(String userName){
        System.out.println(userName+"保存了....");
    }
    public static int show(){
        return 10;
    }
    @Override
    public String toString() {
        return "Fuit{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
