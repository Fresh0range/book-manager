package org.jzy.bookmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * 用户注册
 * @author Fresh0range
 * @since 2020/10/17
 */
@ApiModel("用户注册信息")
@Data
public class UserRegisterDTO {
    @ApiModelProperty(value = "用户名", required = true, example = "zhang san")
    @Size(min = 4, max = 16, message = "用户名长度在4-16位")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "12345678")
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String password;

    @ApiModelProperty(value = "重复密码", required = true, example = "12345678")
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String repeatPassword;

    @ApiModelProperty(value = "邮箱", required = true, example = "12345678@qq.com")
    @Email(message = "邮箱无效")
    private String email;
}
