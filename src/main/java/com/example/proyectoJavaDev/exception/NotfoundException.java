package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class NotfoundException extends CommonException{
    public NotfoundException(CommonErrorResponse commonErrorResponse) {super(commonErrorResponse);}

    public NotfoundException(Throwable cause, CommonErrorResponse commonErrorResponse) {
        super(cause, commonErrorResponse);
    }
}
