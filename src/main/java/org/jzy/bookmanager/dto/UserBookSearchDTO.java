package org.jzy.bookmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 用户搜索书籍
 * @author Fresh0range
 * @since 2020/10/17
 */

@ApiModel("用户书籍信息")
@Data
public class UserBookSearchDTO {
    @ApiModelProperty(value = "书籍编号", required = true, example = "1")
    @NotNull
    private Integer bookId;

    @ApiModelProperty(value = "书籍名称", required = true, example = "数据结构")
    @NotEmpty
    private String bookName;

    @ApiModelProperty(value = "书籍数量", required = true, example = "2")
    @Min(1)
    private Integer bookNum;
}
