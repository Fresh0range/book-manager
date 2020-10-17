package org.jzy.bookmanager.admin.dto;

import lombok.Data;
import org.jzy.bookmanager.entity.Book;

@Data
public class AdminBookChangeDTO {
    private Book book;
    private Integer change;
}
