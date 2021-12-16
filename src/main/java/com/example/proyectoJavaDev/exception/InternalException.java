package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class InternalException extends CommonException{
    public InternalException(Throwable cause, CommonErrorResponse commonErrorResponse) {
        super(cause, commonErrorResponse);
    }
}
