package org.jzy.bookmanager.service;

import org.jzy.bookmanager.dao.UserBookDAO;
import org.jzy.bookmanager.dto.UserBookChangeDTO;
import org.jzy.bookmanager.dto.UserBookSearchDTO;
import org.jzy.bookmanager.entity.Book;
import org.jzy.bookmanager.entity.User;
import org.jzy.bookmanager.entity.UserBook;
import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookService {
    @Autowired
    private UserBookDAO dao;
    @Autowired
    private BookService bookService;
    @Autowired
    @Qualifier("bookLock")
    private Object bookLock;

    public List<UserBookSearchDTO> getUserBookList(User user, Pageable pageable) {
        var userBooks = dao.findByUser(user, pageable);
        return userBooks.stream().map(userBook -> {
            var userBookSearchDTO = new UserBookSearchDTO();
            userBookSearchDTO.setBookId(userBook.getBook().getId());
            userBookSearchDTO.setBookName(userBook.getBook().getName());
            userBookSearchDTO.setBookNum(userBook.getNum());
            return userBookSearchDTO;
        }).collect(Collectors.toList());
    }

    public void changeBook(UserBookChangeDTO userBookChangeDTO, User user) {
        synchronized (bookLock) {
            // 检查书籍能否借还
            bookService.changeBook(userBookChangeDTO);

            var userId = user.getId();
            var bookId = userBookChangeDTO.getBookId();
            var change = -userBookChangeDTO.getChange();// 取负数
            var find = dao.findByUserIdAndBookId(userId, bookId);

            // 如果不存在则插入一条纪录
            if (find == null) {
                if (change < 0) {
                    throw BusinessExceptions.BOOK_CHANGE_NUM_ERROR;
                }
                UserBook userbook = new UserBook();
                userbook.setUser(user);
                var book = new Book();
                book.setId(bookId);
                userbook.setBook(book);
                userbook.setNum(change);
                dao.save(userbook);
            }
            // 如果存在更新数量，如果更新后的数量为0则删除纪录
            else {
                var current = find.getNum();
                var newNum = current + change;

                if (newNum < 0) {
                    throw BusinessExceptions.BOOK_CHANGE_NUM_ERROR;
                } else if (newNum == 0) {
                    dao.delete(find);
                } else {
                    find.setNum(newNum);
                    dao.save(find);
                }
            }
        }

    }
}
