package com.noah.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2019-12-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * 图片链接
     */
    private String image;

    /**
     * 公司地址
     */
    private String address;
    /**
     * 是否有效
     */
    private Integer isValid;

}
