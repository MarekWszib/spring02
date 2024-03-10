package com.example.spring_02;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus // domyślnie 500
    @ExceptionHandler(RuntimeException.class)
    public String handle (RuntimeException e){
        return "Sth went wrong CA";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntryNotFoundException.class)
    public String handle (EntryNotFoundException e){
        return "Sth went wrong CA";
    }

}
