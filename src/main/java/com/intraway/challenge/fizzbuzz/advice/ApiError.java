package com.intraway.challenge.fizzbuzz.advice;

import com.intraway.challenge.fizzbuzz.util.TimeUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String exception;
    private String message;
    private String path;

    public ApiError(HttpStatus status, String exception, String message, String path) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.exception = exception;
        this.message = message;
        this.path = path;
        this.timestamp = TimeUtil.localDateTimeToMillis(LocalDateTime.now());
    }

}
