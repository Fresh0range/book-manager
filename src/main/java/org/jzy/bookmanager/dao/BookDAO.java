package org.jzy.bookmanager.dao;

import org.jzy.bookmanager.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
    Page<Book> findAllByNameLike(String name, Pageable pageable);
}
