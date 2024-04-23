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
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SecurityManage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 安全类型
     */
    private Integer securityType;

    /**
     * 安全描述
     */
    private String securityDesc;

    /**
     * 开启状态,1-启用 0-禁用
     */
    private Integer enableStatus;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新日期
     */
    private Date updateDate;

}
