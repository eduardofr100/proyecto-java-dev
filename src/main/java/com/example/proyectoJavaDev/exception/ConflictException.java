package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class ConflictException extends CommonException{
    public ConflictException(CommonErrorResponse commonErrorResponse) { super(commonErrorResponse);}
}
