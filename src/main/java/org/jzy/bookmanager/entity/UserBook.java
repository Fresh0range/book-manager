package org.jzy.bookmanager.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户书籍实体类
 * @author Fresh0range
 * @since 2020/10/17
 */
@Entity
@Data
@Table
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private Integer num;
}
