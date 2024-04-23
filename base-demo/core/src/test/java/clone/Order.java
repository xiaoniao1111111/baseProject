package clone;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private String orderNo;
    private List<Item> itemList;
}
