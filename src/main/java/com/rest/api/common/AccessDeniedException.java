package com.rest.api.common;
public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String message){
        super(message);
    }

}
