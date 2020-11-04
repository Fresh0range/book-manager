package org.jzy.bookmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户借书还书
 * @author Fresh0range
 * @since 2020/10/17
 */
@ApiModel("用户借还书信息")
@Data
public class UserBookChangeDTO {
    @ApiModelProperty(value = "书籍编号", required = true, example = "1")
    @NotNull
    private Integer bookId;

    @ApiModelProperty(value = "借还数量,借为负数，还为正数", required = true, example = "-2")
    @NotNull
    private Integer change;
}
