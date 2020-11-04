package org.jzy.bookmanager.admin.service;

import org.jzy.bookmanager.admin.dto.AdminBookChangeDTO;
import org.jzy.bookmanager.admin.dao.AdminBookDAO;
import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdminBookService {
    @Autowired
    private AdminBookDAO dao;
    @Autowired
    @Qualifier("bookLock")
    private Object bookLock;

    public void changeBook(AdminBookChangeDTO adminBookChangeDTO) {
        synchronized (bookLock) {
            var book = adminBookChangeDTO.getBook();
            var change = adminBookChangeDTO.getChange();
            var name = book.getName();
            var author = book.getAuthor();
            var find = dao.findByNameAndAuthor(name, author);
            if (find == null) {
                if (change < 0) {
                    throw BusinessExceptions.BOOK_NUM_NOT_ENOUGH;
                }
                book.setNum(change);
                dao.save(book);
            } else {
                var current = find.getNum();
                var newNum = current + change;
                if (newNum < 0) {
                    throw BusinessExceptions.BOOK_NUM_NOT_ENOUGH;
                }
                find.setNum(newNum);
                dao.save(find);
            }
        }
    }
}
