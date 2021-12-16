package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import org.springframework.http.HttpStatus;

public class NotificationBoby extends CommonErrorResponse {
    private String description;
    private String environment;
    private String username;
    private Integer statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
}
