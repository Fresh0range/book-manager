package org.jzy.bookmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 用户登录
 * @author Fresh0range
 * @since 2020/10/17
 */
@ApiModel("用户登录信息")
@Data
public class UserLoginDTO {
    @ApiModelProperty(value = "用户名", required = true, example = "zhang san")
    @Size(min = 4, max = 16, message = "用户名长度在4-16位")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "12345678")
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String password;
}
