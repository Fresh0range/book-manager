package org.jzy.bookmanager.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * 用户注册
 * @author Fresh0range
 * @since 2020/10/17
 */
@Data
public class UserRegisterDTO {
    @Size(min = 4, max = 16, message = "用户名长度在4-16位")
    private String userName;
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String password;
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String repeatPassword;
    @Email(message = "邮箱无效")
    private String email;
}
