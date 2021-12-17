package com.example.proyectoJavaDev.exception.advice;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.proyectoJavaDev.exception.NotfoundException;

@RestControllerAdvice
public class AdviceExceptionController {

    @ExceptionHandler(NotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonErrorResponse handleAllExceptions(NotfoundException exception) {
        return exception.getCommonErrorResponse();
    }


}
