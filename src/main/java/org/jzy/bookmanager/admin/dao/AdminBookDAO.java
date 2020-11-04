package org.jzy.bookmanager.admin.dao;

import org.jzy.bookmanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminBookDAO extends JpaRepository<Book, Integer> {
    Book findByNameAndAuthor(String name, String author);
}
