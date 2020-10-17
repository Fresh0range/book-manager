package org.jzy.bookmanager.controller;

import org.jzy.bookmanager.dto.UserBookChangeDTO;
import org.jzy.bookmanager.dto.UserBookSearchDTO;
import org.jzy.bookmanager.entity.User;
import org.jzy.bookmanager.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user/books")
public class UserBookController {
    @Autowired
    private UserBookService service;

    @GetMapping
    public List<UserBookSearchDTO> getUserBookList(@SessionAttribute User user, @PageableDefault Pageable pageable) {
        return service.getUserBookList(user, pageable);
    }

    @PostMapping
    public void changeBook(@RequestBody @Valid UserBookChangeDTO userBookChangeDTO, @SessionAttribute User user) {
        service.changeBook(userBookChangeDTO, user);
    }
}
