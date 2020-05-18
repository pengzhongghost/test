package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  //直接返回404
public class NotFoundException1 extends RuntimeException{
    public NotFoundException1() {
        super();
    }

    public NotFoundException1(String message) {
        super(message);
    }

    public NotFoundException1(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException1(Throwable cause) {
        super(cause);
    }

    protected NotFoundException1(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
