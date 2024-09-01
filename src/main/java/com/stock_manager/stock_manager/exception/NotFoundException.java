package com.stock_manager.stock_manager.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractException {

    protected NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

}
