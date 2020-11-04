package org.jzy.bookmanager.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("管理员登录信息")
@Data
public class AdminUserLoginDTO {
    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "admin")
    private String password;
}
