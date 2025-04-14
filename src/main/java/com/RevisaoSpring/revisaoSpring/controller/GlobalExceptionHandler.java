package com.RevisaoSpring.revisaoSpring.controller;


import com.RevisaoSpring.revisaoSpring.model.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Professor lidandoComValidator(MethodArgumentNotValidException e){
        return  new Professor();
    }
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
//    public String lidandoComValidator(RuntimeException e){
//        return  e.getMessage();
//    }

}
