package com.shubham.BookAPI.exception;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

public class bookException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public bookException(String message, Throwable throwable,HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;

    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
