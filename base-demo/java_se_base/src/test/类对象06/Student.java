package test.类对象06;

import lombok.Data;

/**
 * @Author: WangXinWei
 * @Date: 2023/05/04/15:44
 * @Description:
 */
@Data
public class Student {
    private String name;
    private String sex;
    private Integer age;
    private String subject;
    private Integer sore;

    public Student(String name, String sex, Integer age, String subject, Integer sore) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.subject = subject;
        this.sore = sore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getSore() {
        return sore;
    }

    public void setSore(Integer sore) {
        this.sore = sore;
    }
}
