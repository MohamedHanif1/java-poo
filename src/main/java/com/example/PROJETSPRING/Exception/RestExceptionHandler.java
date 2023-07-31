package com.example.PROJETSPRING.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class RestExceptionHandler {
    @ExceptionHandler(IdException.class)
    public ResponseEntity<ApiErrorResponse> apiBusinessException(
            IdException businessException) {
        return buildHttpEntity(HttpStatus.BAD_REQUEST, businessException.getExceptionPayload());
    }

    private ResponseEntity<ApiErrorResponse> buildHttpEntity(HttpStatus httpStatus, ExceptionPayload exceptionPayload) {
        return ResponseEntity.status(httpStatus).body(
                ApiErrorResponse.builder()
                        .code(exceptionPayload.getCode())
                        .message(exceptionPayload.getKey())
                        .build());
    }
}
