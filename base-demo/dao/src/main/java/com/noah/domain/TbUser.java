package com.noah.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author wxw
 * @since 2022-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    private Boolean sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

}
