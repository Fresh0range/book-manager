package org.jzy.bookmanager.service;

import org.jzy.bookmanager.dao.UserDAO;
import org.jzy.bookmanager.dto.UserLoginDTO;
import org.jzy.bookmanager.dto.UserRegisterDTO;
import org.jzy.bookmanager.entity.User;
import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserDAO dao;

    public void register(UserRegisterDTO userRegisterDTO) {
        // 检验用户名是否存在
        var userName = userRegisterDTO.getUsername();
        var find = dao.findByUsername(userName);
        if (find != null) {
            throw BusinessExceptions.USERNAME_ALREADY_EXIST;
        }
        // 检验两次密码是否一致
        var password = userRegisterDTO.getPassword();
        var repeatPassword = userRegisterDTO.getRepeatPassword();
        if (!Objects.equals(password, repeatPassword)) {
            throw BusinessExceptions.PASSWORD_NOT_SAME;
        }
        // 保存用户信息
        var email = userRegisterDTO.getEmail();
        var user = new User();
        user.setUsername(userName);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setEmail(email);
        dao.save(user);
    }

    public User login(UserLoginDTO userLoginDTO) {
        var userName = userLoginDTO.getUsername();
        var password = DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes());
        var user = dao.findByUsernameAndPassword(userName, password);
        if (user == null) {
            throw BusinessExceptions.USERNAME_OR_PASSWORD_ERROR;
        }
        return user;
    }
}
