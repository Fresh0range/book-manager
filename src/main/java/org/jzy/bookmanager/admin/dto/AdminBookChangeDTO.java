package org.jzy.bookmanager.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jzy.bookmanager.entity.Book;

@ApiModel("增删书籍信息")
@Data
public class AdminBookChangeDTO {
    @ApiModelProperty(value = "", required = true)
    private Book book;

    @ApiModelProperty(value = "", required = true, example = "2")
    private Integer change;
}
