package org.jzy.bookmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 书籍实体类
 * @author Fresh0range
 * @since 2020/10/17
 */
@ApiModel("书籍实体类")
@Entity
@Data
@Table
public class Book {
    @ApiModelProperty(value = "书籍编号【自动生成】", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "书籍名称", required = true, example = "数据结构")
    private String name;

    @ApiModelProperty(value = "书籍作者", required = true, example = "严蔚敏")
    private String author;

    @ApiModelProperty(value = "书籍发布时间", required = true, example = "2020-11-04")
    @JsonFormat(pattern = "yyyy-MM-dd") // 将数据库中的日期按格式发送给前台
    private Date publish;

    @ApiModelProperty(value = "书籍简介", required = true, example = "数据结构是计算机存储、组织数据的方式。")
    private String introduce;

    @ApiModelProperty(value = "书籍库存", required = true, example = "10")
    private Integer num;
}
