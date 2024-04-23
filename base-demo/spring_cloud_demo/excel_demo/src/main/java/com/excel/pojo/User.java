package com.excel.pojo;
import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * 员工
 */
@Data
@Table(name="tb_user")
public class  User {
    @Id
    @KeySql(useGeneratedKeys = true)
    // name: 导出列名称  orderNum: 排序  width: 列宽,isImportField: 是否作为导入的属性,true是,false不是
    @Excel(name = "编号",orderNum = "0",width = 5)
    private Long id;         //主键
    @Excel(name = "员工名",orderNum = "1",width = 15,isImportField = "true")
    private String userName; //员工名
    @Excel(name = "手机号",orderNum = "2",width = 15,isImportField = "true")
    private String phone;    //手机号
    @Excel(name = "省份名",orderNum = "3",width = 15,isImportField = "true")
    private String province; //省份名
    @Excel(name = "城市名",orderNum = "4",width = 15,isImportField = "true")
    private String city;     //城市名
    // type: 指定数据的数据类型,默认1是文本,10是数字
    @Excel(name = "工资",orderNum = "5",width = 15,type = 10,isImportField = "true")
    private Integer salary;   // 工资
    @Excel(name = "入职日期",orderNum = "6",width = 10,format = "yyyy-MM-dd",isImportField = "true")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date hireDate; // 入职日期
    private String deptId;   //部门id
    @Excel(name = "出生日期",orderNum = "7",width = 10,format = "yyyy-MM-dd",isImportField = "true")
    private Date birthday; //出生日期
    // type=2 该字段类型为照片类型,savePath:表示路径存放的位置
    @Excel(name = "一寸照片",orderNum = "9",width = 20,type = 2,isImportField = "true",savePath = "D:\\project\\user_management\\src\\main\\resources\\static\\user_photos")
    private String photo;    //一寸照片
    @Excel(name = "现在居住地址",orderNum = "8",width = 20,isImportField = "true")
    private String address;  //现在居住地址
    private List<Resource> resourceList; //办公用品

    @JsonIgnore //转json时不考虑这个字段
    @Transient //这个字段不需要和表对应
    private String hireDateStr;

}
