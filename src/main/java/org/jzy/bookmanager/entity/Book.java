package org.jzy.bookmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 书籍实体类
 * @author Fresh0range
 * @since 2020/10/17
 */
@Entity
@Data
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd") // 将数据库中的日期按格式发送给前台
    private Date publish;
    private String introduce;
    private Integer num;
}
