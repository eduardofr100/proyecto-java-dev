package com.example.proyectoJavaDev.exception;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoryException {
    public FactoryException() {
    }

    public static InternalException throwInternalException(
            Throwable exception,
            List<String> errors,
            String process,
            String message
    ) {
        return new InternalException(exception, new CommonErrorResponse(
                errors,
                message,
                process,
                HttpStatus.INTERNAL_SERVER_ERROR
        ));
    }

    public static NotfoundException throwNotFoundException(
            String error,
            String process,
            String message
    ) {
        return new NotfoundException(new CommonErrorResponse(
                // lines tiene la misma funcionalidad de Stream
                error.lines().collect(Collectors.toList()),
                message,
                process,
                HttpStatus.NOT_FOUND
        ));
    }

    public static NotfoundException throwNotFoundException(
            List<String> error,
            String message,
            String process
    ) {
        return new NotfoundException(new CommonErrorResponse(
                error,
                message,
                process,
                HttpStatus.NOT_FOUND
        ));
    }

    public static MultipleChoicesException throwMultipleChoicesException(
            String error,
            String message,
            String process
    ) {
        return new MultipleChoicesException(new CommonErrorResponse(
                error.lines().collect(Collectors.toList()),
                message,
                process,
                HttpStatus.MULTIPLE_CHOICES
        ));
    }
}
