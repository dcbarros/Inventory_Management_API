package com.stock_manager.stock_manager.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {

    protected AbstractException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

}
