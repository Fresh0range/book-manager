package org.jzy.bookmanager.admin.controller;

import org.jzy.bookmanager.admin.dto.AdminBookChangeDTO;
import org.jzy.bookmanager.admin.service.AdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/books")
public class AdminBookController {
    @Autowired
    private AdminBookService service;

    @PostMapping
    public void changeBook(@RequestBody AdminBookChangeDTO adminBookChangeDTO) {
        service.changeBook(adminBookChangeDTO);
    }
}
