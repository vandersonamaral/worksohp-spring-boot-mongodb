package com.amaraldev.workshopmongo.services.exception;

public class ObjectNotFoundExeception extends RuntimeException{

    public ObjectNotFoundExeception(String msg) {
        super(msg);
    }
}
