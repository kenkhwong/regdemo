package com.example.demo.controller;

import com.example.demo.service.UnderAgeException;
import com.example.demo.service.UserExistsException;
import com.example.demo.service.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(UnderAgeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleException(UnderAgeException e) {
        return HttpStatus.FORBIDDEN.toString();
    }

    @ResponseBody
    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleException(UserExistsException e) {
        return HttpStatus.CONFLICT.toString();
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleException(UserNotFoundException e) {
        return HttpStatus.NOT_FOUND.toString();
    }
}
