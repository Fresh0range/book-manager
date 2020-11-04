package org.jzy.bookmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.jzy.bookmanager.entity.Book;
import org.jzy.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "书籍管理")
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService service;

    @ApiOperation(value = "根据名称搜索书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "关键字类别", required = true, paramType = "query", dataTypeClass = String.class, example = "name"),
            @ApiImplicitParam(name = "value", value = "关键字", required = true, paramType = "query", dataTypeClass = String.class, allowEmptyValue = true)
    })
    @GetMapping("searchBy")
    public List<Book> getBookListBy(@RequestParam String key, @RequestParam String value, @ApiIgnore @PageableDefault Pageable pageable) {
        if ("name".equals(key)) {
            return service.getBookListByName(value, pageable);
        }
        return null;
    }

    @ApiOperation(value = "获取书籍详情")
    @ApiImplicitParam(name = "id", value = "书籍编号", required = true, paramType = "path", dataTypeClass = Integer.class)
    @GetMapping("{id}")
    public Book getBookDetail(@PathVariable Integer id) {
        return service.getBook(id);
    }
}
