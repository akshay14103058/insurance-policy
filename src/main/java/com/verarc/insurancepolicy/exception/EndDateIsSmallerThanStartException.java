package com.verarc.insurancepolicy.exception;

import org.springframework.http.HttpStatus;

public class EndDateIsSmallerThanStartException extends RuntimeException {
    private String errorMessage;
    public EndDateIsSmallerThanStartException( String errorMessage){
        super(errorMessage);
    }
}
