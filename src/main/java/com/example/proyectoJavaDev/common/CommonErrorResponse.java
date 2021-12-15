package com.example.proyectoJavaDev.common;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

public class CommonErrorResponse implements Serializable {
    @Schema(description = "Listado de errores")
    private List<String> errors;

    @Schema(description = "Mensaje de error")
    private String message;

    @Schema(description = "Proceso")
    private String process;

    @Schema(description = "HTTP Status")
    private HttpStatus httpStatus;

    public CommonErrorResponse(List<String> errors, String message, String process, HttpStatus httpStatus) {
        this.errors = errors;
        this.message = message;
        this.process = process;
        this.httpStatus = httpStatus;
    }

    public CommonErrorResponse(){}

    public List<String> getErrorss() {
        return errors;
    }

    public void setErrorss(List<String> errorss) {
        this.errors = errorss;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "CommonErrorResponse{" +
                "errorss=" + errors +
                ", message='" + message + '\'' +
                ", process='" + process + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
