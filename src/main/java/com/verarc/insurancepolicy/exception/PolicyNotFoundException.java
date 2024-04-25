package com.verarc.insurancepolicy.exception;

public class PolicyNotFoundException extends RuntimeException{
    private String errorMessage;

    public PolicyNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
