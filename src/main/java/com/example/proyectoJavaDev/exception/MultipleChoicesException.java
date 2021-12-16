package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public class MultipleChoicesException extends CommonException {
    public MultipleChoicesException(CommonErrorResponse commonErrorResponse){ super(commonErrorResponse);}
    public static MultipleChoicesException trowMultipleChoicesException(List<String> error,
                                                                        String message,
                                                                        String process,
                                                                        HttpStatus status){
        return new MultipleChoicesException(
                new CommonErrorResponse(error,message,process,status)
        );
    }
}
