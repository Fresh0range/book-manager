package org.jzy.bookmanager.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户实体类
 * @author Fresh0range
 * @since 2020/10/17
 */
@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
}
