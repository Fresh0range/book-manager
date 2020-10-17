package org.jzy.bookmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false) // 不调用父类的equals和hashcode方法
public class BusinessException extends RuntimeException {
    private Integer errCode;
    private Object errMessage;
}
