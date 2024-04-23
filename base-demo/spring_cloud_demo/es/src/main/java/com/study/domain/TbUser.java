package com.study.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author wxw
 * @since 2024-03-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 薪水
     */
    private String salary;

    /**
     * 入职日期
     */
    private Date hireDate;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 照片
     */
    private String photo;

    /**
     * 地址
     */
    private String address;

}
