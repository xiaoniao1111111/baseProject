package test.异常线程;

import lombok.Data;

/**
 * @Author: WangXinWei
 * @Date: 2023/05/08/11:25
 * @Description:
 */
@Data
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
