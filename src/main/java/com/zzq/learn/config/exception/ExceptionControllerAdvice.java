package com.zzq.learn.config.exception;

import com.zzq.learn.enums.SysError;
import com.zzq.learn.model.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice extends R {

    @ExceptionHandler(Exception.class)
    public R getException(Exception exception) {
        exception.printStackTrace();
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) exception;
            if (e.getFieldErrorCount() > 0) {
                Map<String, String> map = new HashMap<>();
                for (FieldError error : e.getFieldErrors()) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
                return fail(SysError.InvalidArgument, map);
            }
        }
        return fail(SysError.Undefined, exception.getMessage());
    }
}


