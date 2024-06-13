package com.stock_manager.stock_manager.model.enums;

public enum ProductCategories {
    ROUPAS_ADULTO("11"),
    ROUPAS_INFANTIS("22"),
    MODA_PRAIA("33"),
    QUARTO("44"),
    COZINHA("55"),
    OUTROS("66");

    private String codeNumber;

    ProductCategories(String codeNumber){
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber(){
        return this.codeNumber;
    }

}
