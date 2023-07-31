package com.example.PROJETSPRING.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class IdException extends RuntimeException {

    private final ExceptionPayload exceptionPayload;

    public IdException(ExceptionPayload exceptionPayload) {
        this.exceptionPayload = exceptionPayload;
    }


}

