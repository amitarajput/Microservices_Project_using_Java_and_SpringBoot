package com.amita.user.service.exceptions;

import com.amita.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

     @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFound rn){
         String message = rn.getMessage();
         ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();// build any class object in one line
         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
