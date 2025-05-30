package com.vti.bep3.exception;

import com.vti.bep3.entity.CustomException;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {
    // Mehtod bắt lỗi validate
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleBindException(BindException e, HttpServletRequest request) {
        String errorMessage = "";
        if (e.getBindingResult().hasErrors()) {
            for (int i = 0; i < e.getBindingResult().getAllErrors().size(); i++) {
                errorMessage += e.getBindingResult().getAllErrors().get(i).getDefaultMessage();
                errorMessage += (i == e.getBindingResult().getAllErrors().size() - 1) ? "." : ", ";
            }
        }
        CustomException appException = new CustomException();
        appException.setMessage(errorMessage);
        appException.setStatus(400);
        appException.setTimestamp(new Date());
        appException.setPath(request.getRequestURI());
        return ResponseEntity.status(400).body(appException);
    }

    // Mehtod bắt lỗi LogicCustomException
    @ExceptionHandler(LogicCustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleLogicException(LogicCustomException e, HttpServletRequest request) {
        CustomException appException = new CustomException();
        appException.setMessage(e.getMessage());
        appException.setStatus(e.getCode());
        appException.setTimestamp(new Date());

        appException.setPath(request.getRequestURI());
        return ResponseEntity.status(400).body(appException);
    }
    @ExceptionHandler(SignatureException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleSignatureException(LogicCustomException e, HttpServletRequest request) {
        CustomException appException = new CustomException();
        appException.setMessage(e.getMessage());
        appException.setStatus(e.getCode());
        appException.setTimestamp(new Date());

        appException.setPath(request.getRequestURI());
        return ResponseEntity.status(400).body(appException);
    }
}
