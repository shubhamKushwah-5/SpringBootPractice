package com.shubham.BookAPI.exception;

public class bookNotFoundException extends RuntimeException {

    public bookNotFoundException(Long id){
        super("book not exist with id: " + id);
    }

    public bookNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public bookNotFoundException(String message){
        super(message);
    }
}
