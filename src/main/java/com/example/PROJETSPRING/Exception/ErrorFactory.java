package com.example.PROJETSPRING.Exception;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorFactory {
    USER_NOT_FOUND("user.not.found", 1);
   /* HOLIDAY_REQUEST_NOT_FOUND("holiday.request.not.found",2),
    INSUFFICIENT_USER_LEAVE_BALANCE("insufficient.user.leave.balance",3),
    HOLIDAY_REQUEST_USER_NULL("holiday.request.user.null",4),
    OBJECTIF_NOT_FOUND("objectif.not.found",5),
    KEY_RESULTS_NOT_FOUND("key.result.not.found",6);*/

    private String msgKey;
    private Integer code;


    public ExceptionPayload getExceptionPayload() {
        return new ExceptionPayload(msgKey, code);
}
}
