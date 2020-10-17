package org.jzy.bookmanager.dto;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * 用户登录
 * @author Fresh0range
 * @since 2020/10/17
 */
@Data
public class UserLoginDTO {
    @Size(min = 4, max = 16, message = "用户名长度在4-16位")
    private String userName;
    @Size(min = 8, max = 16, message = "密码长度在8-16位")
    private String password;
}
