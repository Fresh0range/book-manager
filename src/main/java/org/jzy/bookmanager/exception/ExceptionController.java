package org.jzy.bookmanager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 异常统一处理类
 * @author Fresh0range
 * @since 2020/10/17
 */
@ControllerAdvice // 处理其他controller类抛出的异常
@ResponseBody // 异常信息以json格式发送给请求端
@Slf4j
public class ExceptionController {
    /**
     * 处理业务异常
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(BusinessException.class) // 能够处理的异常类
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) // http返回的错误码
    public Map<String, Object> handleException(BusinessException e) {
        return toMap(e.getErrCode(), e.getErrMessage());
    }

    /**
     * 处理数据校验异常
     * @param e 异常
     * @return 异常信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> errMessage = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errMessage.add(fieldError.getDefaultMessage());
        }
        return toMap(-1, errMessage);
    }

    private Map<String, Object> toMap(int errCode, Object errMessage) {
        Map<String, Object> result = new HashMap<>();
        result.put("errCode", errCode);
        result.put("errMessage", errMessage);
        log.error(result.toString());
        return result;
    }
}
