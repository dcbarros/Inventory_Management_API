package com.stock_manager.stock_manager.exception;

public class ExcededAttmptsException extends LoopDetectedException{

    public ExcededAttmptsException(String field) {
        super("O número de tentativas para gerar o " + field + " foi excedido, tente novamente mais tarde!");
    }
    
}
