package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class BadRequestException extends CommonException {
    public BadRequestException(CommonErrorResponse commonErrorResponse) { super(commonErrorResponse);}
}
