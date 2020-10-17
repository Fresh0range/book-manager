package org.jzy.bookmanager.admin.controller;

import org.jzy.bookmanager.admin.dto.AdminUserLoginDTO;
import org.jzy.bookmanager.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserService service;

    @PostMapping("login")
    public void login(@RequestBody AdminUserLoginDTO adminUserLoginDTO, HttpSession session) {
        service.login(adminUserLoginDTO);
        session.setAttribute("adminUser", true);
    }

    @PostMapping("logout")
    public void logout(HttpSession session) {
        session.removeAttribute("adminUser");
    }
}
