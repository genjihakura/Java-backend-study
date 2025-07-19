package vn.vti.dtn2501.user.exception;

import org.springframework.http.HttpStatus;
import vn.vti.dtn2501.common.api.exeption.VMallExceptionInfo;

public enum ExceptionEnum implements VMallExceptionInfo {
    BAD_REQUEST(
            "BAD_REQUEST",
            "Bad request",
            HttpStatus.BAD_REQUEST
    ),
    USER_NO_EXIST(
            "USER_NO_EXIST",
            "user no exist",
            HttpStatus.BAD_REQUEST
    ),
    USER_EXISTED(
            "USER_EXISTED",
            "user existed",
            HttpStatus.BAD_REQUEST
    )
    ;

    private final String errorCode;
    private final String errorDescription;
    private final HttpStatus httpStatus;

    ExceptionEnum(String errorCode, String errorDescription, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }
    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorDescription() {
        return this.errorDescription;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
