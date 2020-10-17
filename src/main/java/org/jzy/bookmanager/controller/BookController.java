package org.jzy.bookmanager.controller;

import org.jzy.bookmanager.entity.Book;
import org.jzy.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("searchBy")
    public List<Book> getBookListBy(@RequestParam String key, @RequestParam String value, @PageableDefault Pageable pageable) {
        if ("name".equals(key)) {
            return service.getBookListByName(value, pageable);
        }
        return null;
    }


    @GetMapping("{id}")
    public Book getBookDetail(@PathVariable Integer id) {
        return service.getBook(id);
    }
}
