package org.jzy.bookmanager.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jzy.bookmanager.admin.dto.AdminBookChangeDTO;
import org.jzy.bookmanager.admin.service.AdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理员--书籍管理")
@RestController
@RequestMapping("/api/admin/books")
public class AdminBookController {
    @Autowired
    private AdminBookService service;

    @ApiOperation(value = "增删书籍")
    @ApiParam(name = "adminBookChangeDTO", required = true)
    @PostMapping
    public void changeBook(@RequestBody AdminBookChangeDTO adminBookChangeDTO) {
        service.changeBook(adminBookChangeDTO);
    }
}
