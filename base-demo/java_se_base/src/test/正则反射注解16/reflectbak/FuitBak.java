package test.正则反射注解16.reflectbak;

/**
 * @Author WangXinWei
 * @Date 2022/3/8 9:53
 * @Version 1.0
 */
public class FuitBak {
    private String name;
    private Double price;

    public FuitBak() {
    }

    public FuitBak(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FuitBak{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void save() {
        System.out.println("今天早上吃饭了....");
    }

    public static String save(String name) {
        System.out.println(name + "今天早上吃饭了....");
        return name;
    }
}
