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
 * @since 2019-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Long userId;

    /**
     * 商品名称
     */
    private String itemName;

    /**
     * 商品价格
     */
    private Float itemPrice;

    /**
     * 商品描述
     */
    private String itemDetail;

    private Integer age;

}
