package test.idea04;

public class Fuit {
    private String name;
    private String price;

    public Fuit(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public Fuit() {
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
}
