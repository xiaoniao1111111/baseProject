package com.noah.req;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/30 17:29
 * @Version 1.0
 */
@Data
public class PageReq {
    @ApiModelProperty("age")
    @NotNull(message = "用户年龄不可为空")
    private Integer age;
}
