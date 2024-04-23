package test.类对象06;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Zoo {
    // 名字
    private String name;
    // 眼睛
    private String eye;
    // 嘴巴
    private String month;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
