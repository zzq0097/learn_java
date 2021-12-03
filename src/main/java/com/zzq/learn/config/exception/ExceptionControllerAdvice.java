package com.zzq.learn.config.exception;

import com.zzq.learn.model.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice extends R {

    @ExceptionHandler(Exception.class)
    public R getException(Exception e) {
        e.printStackTrace();
        return fail(e.getMessage());
    }
}


