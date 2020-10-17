package org.jzy.bookmanager.service;

import org.jzy.bookmanager.dao.BookDAO;
import org.jzy.bookmanager.dto.UserBookChangeDTO;
import org.jzy.bookmanager.entity.Book;
import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDAO dao;

    public List<Book> getBookListByName(String name, Pageable pageable) {
        var page = dao.findAllByNameLike("%" + name + "%", pageable);
        return page.getContent();
    }

    public Book getBook(Integer id) {
        var optional = dao.findById(id);
        if (optional.isEmpty()) {
            throw BusinessExceptions.BOOK_NOT_EXIST;
        }
        return optional.get();
    }

    public void changeBook(UserBookChangeDTO userBookChangeDTO) {
        // 检验书籍是否存在
        var bookId = userBookChangeDTO.getBookId();
        var find = dao.findById(bookId);
        if (find.isEmpty()) {
            throw BusinessExceptions.BOOK_NOT_EXIST;
        }
        // 检查书籍库存是否足够
        var book = find.get();
        var current = book.getNum();
        var change = userBookChangeDTO.getChange();
        var newNum = current + change;
        if (newNum < 0) {
            throw BusinessExceptions.BOOK_NUM_NOT_ENOUGH;
        }
        // 保存
        book.setNum(newNum);
        dao.save(book);
    }
}
