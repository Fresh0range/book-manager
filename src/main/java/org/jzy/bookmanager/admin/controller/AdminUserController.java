package org.jzy.bookmanager.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jzy.bookmanager.admin.dto.AdminUserLoginDTO;
import org.jzy.bookmanager.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@Api(tags = "管理员--用户管理")
@RestController
@RequestMapping("api/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserService service;

    @ApiOperation(value = "登录")
    @ApiParam(name = "adminUserLoginDTO", required = true)
    @PostMapping("login")
    public void login(@RequestBody AdminUserLoginDTO adminUserLoginDTO, @ApiIgnore HttpSession session) {
        service.login(adminUserLoginDTO);
        session.setAttribute("adminUser", true);
    }

    @ApiOperation(value = "登出")
    @PostMapping("logout")
    public void logout(@ApiIgnore HttpSession session) {
        session.removeAttribute("adminUser");
    }
}
