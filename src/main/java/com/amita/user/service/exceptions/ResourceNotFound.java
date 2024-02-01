package com.amita.user.service.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String s){// constructor
        super("Resource not found on server");
    }
}
