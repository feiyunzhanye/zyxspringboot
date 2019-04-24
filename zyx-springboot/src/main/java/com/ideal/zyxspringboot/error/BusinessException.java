package com.ideal.zyxspringboot.error;

public class BusinessException extends RuntimeException {
    public BusinessException(){}
    public BusinessException(String message){
        super(message);
    }
}
