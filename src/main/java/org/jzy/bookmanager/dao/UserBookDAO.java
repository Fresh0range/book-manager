package org.jzy.bookmanager.dao;

import org.jzy.bookmanager.entity.User;
import org.jzy.bookmanager.entity.UserBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookDAO extends JpaRepository<UserBook, Integer> {
    Page<UserBook> findByUser(User user, Pageable pageable);

    UserBook findByUserIdAndBookId(Integer userId, Integer bookId);
}
