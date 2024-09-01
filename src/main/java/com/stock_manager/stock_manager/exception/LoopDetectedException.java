package com.stock_manager.stock_manager.exception;

import org.springframework.http.HttpStatus;

public class LoopDetectedException extends AbstractException{

    protected LoopDetectedException(String message){
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.LOOP_DETECTED;
    }
    
}
