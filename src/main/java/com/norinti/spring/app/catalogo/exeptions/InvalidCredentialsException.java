package com.norinti.spring.app.catalogo.exeptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String message){
        super(message);
    }


}
