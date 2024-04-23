package com.study.domain;
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
 * @since 2024-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbHotel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 得分
     */
    private Integer score;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 城市
     */
    private String city;

    /**
     * 星级
     */
    private String starName;

    /**
     * 商业圈
     */
    private String business;

    /**
     * 经度
     */
    private String latitude;

    /**
     * 维度
     */
    private String longitude;

    /**
     * 图片信息
     */
    private String pic;

}
