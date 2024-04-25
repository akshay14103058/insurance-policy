package com.verarc.insurancepolicy.exception;

public class NotValidValueException extends RuntimeException{
    private String errorMessage;
    public NotValidValueException(String errorMessage){
        super(errorMessage);
    }
}
