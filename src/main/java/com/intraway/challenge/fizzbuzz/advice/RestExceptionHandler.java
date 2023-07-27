package com.intraway.challenge.fizzbuzz.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<Object> handleConstraintViolation(IllegalArgumentException ex, HttpServletRequest httpRequest) {
        log.error("Illegal argument exception ocurred", ex);
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getClass().toString(),
                ex.getMessage(), httpRequest.getServletPath());
        return ResponseEntity.badRequest().body(apiError);
    }
}
