package com.example.PROJETSPRING.Exception;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private Integer code;
    private String message;
}