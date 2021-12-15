package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class CommonException extends  Exception{

    private final CommonErrorResponse commonErrorResponse;

    public CommonException(Throwable cause, CommonErrorResponse commonErrorResponse) {
        super(cause);
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonException(CommonErrorResponse commonErrorResponse) {
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonErrorResponse getCommonErrorResponse() {
        return commonErrorResponse;
    }
}
