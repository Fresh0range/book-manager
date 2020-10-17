package org.jzy.bookmanager.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 用户搜索书籍
 * @author Fresh0range
 * @since 2020/10/17
 */
@Data
public class UserBookSearchDTO {
    @NotNull
    private Integer bookId;
    @NotEmpty
    private String bookName;
    @Min(1)
    private Integer bookNum;
}
