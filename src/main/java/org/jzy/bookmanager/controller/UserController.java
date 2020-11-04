package org.jzy.bookmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jzy.bookmanager.dto.UserLoginDTO;
import org.jzy.bookmanager.dto.UserRegisterDTO;
import org.jzy.bookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Api(tags = "用户管理")
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService service;

    @ApiOperation(value = "注册")
    @ApiParam(name = "userRegisterDTO", required = true)
    @PostMapping("register")
    public void register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        service.register(userRegisterDTO);
    }

    @ApiOperation(value = "登录")
    @ApiParam(name = "userLoginDTO", required = true)
    @PostMapping("login")
    public void login(@RequestBody @Valid UserLoginDTO userLoginDTO, @ApiIgnore HttpSession session) {
        var user = service.login(userLoginDTO);
        session.setAttribute("user", user);
    }

    @ApiOperation(value = "登出")
    @PostMapping("logout")
    public void logout(@ApiIgnore HttpSession session) {
        session.removeAttribute("user");
    }
}
