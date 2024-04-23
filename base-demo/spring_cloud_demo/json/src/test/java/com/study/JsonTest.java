package com.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.study.pojo.Student;
import org.junit.Test;

import java.util.*;

/**
 * @类名称:JsonTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-20
 * @版本:V1.0.0
 */
public class JsonTest {

    /**
     * 对象转json
     */
    @Test
    public void objectToJson() {
        Student student = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        String json = JSON.toJSONString(student);
        System.out.println("对象转JSON: " + json);
    }

    /**
     * 集合转json
     */
    @Test
    public void listToJson() {
        Student student = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        Student student1 = Student.builder().id(2).age(2).birthday(new Date()).name("李四").build();
        List<Student> list = Arrays.asList(student, student1);
        String json = JSON.toJSONString(list);
        System.out.println("集合转JSON: " + json);
    }

    /**
     * map转json
     */
    @Test
    public void mapToJson() {
        Student student1 = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        Student student2 = Student.builder().id(2).age(2).birthday(new Date()).name("李四").build();
        Map<String, Student> map = new HashMap<>();
        map.put("student1", student1);
        map.put("student2", student2);
        String json = JSON.toJSONString(map);
        System.out.println("map转JSON: " + json);
    }

    /**
     * json转对象
     */
    @Test
    public void jsonToObject() {
        Student student = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        String json = JSON.toJSONString(student);
        Student result = JSON.parseObject(json, Student.class);
        System.out.println("JSON转对象: " + result);
    }


    /**
     * json转集合
     */
    @Test
    public void jsonToList() {
        Student student = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        Student student1 = Student.builder().id(2).age(2).birthday(new Date()).name("李四").build();
        List<Student> list = Arrays.asList(student, student1);
        String json = JSON.toJSONString(list);
        List<Student> result = JSON.parseArray(json, Student.class);
        System.out.println("JSON转集合: " + result.toString());
    }

    /**
     * json转map
     */
    @Test
    public void jsonToMap() {
        Student student1 = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        Student student2 = Student.builder().id(2).age(2).birthday(new Date()).name("李四").build();
        Map<String, Student> map = new HashMap<>();
        map.put("student1", student1);
        map.put("student2", student2);
        String json = JSON.toJSONString(map);
        Map<String, Student> studentMap = JSON.parseObject(json, new TypeReference<Map<String, Student>>() {});
        for (String key : studentMap.keySet()) {
            System.out.println(key+"---------"+studentMap.get(key));
        }
    }

    /**
     * 将为null或者没有设置字段序列化后展示出来
     */
    @Test
    public void serializerFeatureToNull() {
        Student student = Student.builder().id(1).age(2).birthday(new Date()).name("张三").build();
        String json = JSON.toJSONString(student, SerializerFeature.PrettyFormat);
        System.out.println("对象转JSON: " + json);
    }

    /**
     * 作用在成员变量上,可以修改字段的变量名
     */
    @Test
    public void jsonFieldToName(){
        Student student = Student.builder().id(1).email("2284562951@qq.com").age(2).birthday(new Date()).name("张三").build();
        String json = JSON.toJSONString(student, SerializerFeature.PrettyFormat);
        System.out.println(json);
    }
}
