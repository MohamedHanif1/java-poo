package com.example.PROJETSPRING.Exception;
import lombok.*;

@Getter
@NoArgsConstructor
public class ExceptionPayload {
    private String key;
    private Integer code;
    private Object[] messageKeyParameters;

    public ExceptionPayload(String key, Integer code) {
        this.code = code;
        this.key = key;
    }
}
