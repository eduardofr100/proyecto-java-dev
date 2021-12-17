package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;

public class CommonException extends  Exception{

    private final CommonErrorResponse commonErrorResponse;

    public CommonException(Throwable cause, CommonErrorResponse commonErrorResponse) {
        super(cause);
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, CommonErrorResponse commonErrorResponse) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonException(CommonErrorResponse commonErrorResponse) {
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonException(String message, CommonErrorResponse commonErrorResponse) {
        super(message);
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonException(String message, Throwable cause, CommonErrorResponse commonErrorResponse) {
        super(message, cause);
        this.commonErrorResponse = commonErrorResponse;
    }

    public CommonErrorResponse getCommonErrorResponse() {
        return commonErrorResponse;
    }


}
