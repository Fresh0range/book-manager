package org.jzy.bookmanager.controller;

import org.jzy.bookmanager.dto.UserLoginDTO;
import org.jzy.bookmanager.dto.UserRegisterDTO;
import org.jzy.bookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("register")
    public void register(@RequestBody @Valid UserRegisterDTO userRegisterDTO) {
        service.register(userRegisterDTO);
    }

    @PostMapping("login")
    public void login(@RequestBody @Valid UserLoginDTO userLoginDTO, HttpSession session) {
        var user = service.login(userLoginDTO);
        session.setAttribute("user", user);
    }

    @PostMapping("logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
}
