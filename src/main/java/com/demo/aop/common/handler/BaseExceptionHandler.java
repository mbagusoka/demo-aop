package com.demo.aop.common.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler
    public String baseExceptionHandler(Exception e) {
        return e.getMessage();
    }
}
