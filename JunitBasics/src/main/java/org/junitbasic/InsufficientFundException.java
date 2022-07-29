package org.junitbasic;

public class InsufficientFundException extends Exception{
    public InsufficientFundException(String errorMessage){
        super(errorMessage);
    }
}
