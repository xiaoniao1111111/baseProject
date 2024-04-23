package com.study.domain;
import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author wxw
 * @since 2024-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String moble;

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
    @TableField(select = false)
    private String address;

    @TableField(exist = false)
    private String img;

    @Version // 乐观锁的版本字段
    private Integer version;

}