package org.jzy.bookmanager.admin.service;

import org.jzy.bookmanager.admin.dto.AdminUserLoginDTO;
import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminUserService {
    public void login(AdminUserLoginDTO adminUserLoginDTO) {
        var userName = adminUserLoginDTO.getUserName();
        var password = adminUserLoginDTO.getPassword();
        // 管理员的用户名和密码先固定为admin和admin
        if (!Objects.equals("admin", userName) || !Objects.equals("admin", password)) {
            throw BusinessExceptions.USERNAME_OR_PASSWORD_ERROR;
        }
    }
}
