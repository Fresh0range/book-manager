package org.jzy.bookmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jzy.bookmanager.dto.UserBookChangeDTO;
import org.jzy.bookmanager.dto.UserBookSearchDTO;
import org.jzy.bookmanager.entity.User;
import org.jzy.bookmanager.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "用户书籍接口")
@RestController
@RequestMapping("/api/user/books")
public class UserBookController {
    @Autowired
    private UserBookService service;

    @ApiOperation(value = "获取用户的所有书籍")
    @GetMapping
    public List<UserBookSearchDTO> getUserBookList(@ApiIgnore @SessionAttribute User user, @PageableDefault Pageable pageable) {
        return service.getUserBookList(user, pageable);
    }

    @ApiOperation(value = "用户借还书籍")
    @ApiParam(name = "userBookChangeDTO", required = true)
    @PostMapping
    public void changeBook(@RequestBody @Valid UserBookChangeDTO userBookChangeDTO, @ApiIgnore @SessionAttribute User user) {
        service.changeBook(userBookChangeDTO, user);
    }
}
