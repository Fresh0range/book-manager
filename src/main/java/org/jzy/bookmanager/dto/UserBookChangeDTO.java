package org.jzy.bookmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户借书还书
 * @author Fresh0range
 * @since 2020/10/17
 */
@Data
public class UserBookChangeDTO {
    @NotNull
    private Integer bookId;
    @NotNull
    private Integer change;
}
