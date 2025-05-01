package com.vti.hello_world.exception;

import com.vti.hello_world.modal.CustomException;
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
//    @ExceptionHandler(AppException.class)
//    public ResponseEntity<AppException> catchExceptionCustom(AppException exception, HttpServletRequest request){
//        exception.setPath(request.getRequestURI());
//        return ResponseEntity.status(exception.getCode())
//                .body(exception);
//    }


    // Mehtod bắt lỗi validate
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomException> handleBindException(BindException e, HttpServletRequest request) {
        String errorMessage = "";
        if (e.getBindingResult().hasErrors()){
            for(int i=0;i< e.getBindingResult().getAllErrors().size();i++){
                errorMessage += e.getBindingResult().getAllErrors().get(i).getDefaultMessage();
                errorMessage += (i==e.getBindingResult().getAllErrors().size()-1) ? "." : ", ";
            }
        }
        CustomException appException= new CustomException();
        appException.setMessage(errorMessage);
        appException.setPath(request.getRequestURI());
        appException.setTimestamp(new Date());
        return ResponseEntity.status(400).body(appException);
    }


//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<AppException> catchExceptionGlobal(Exception exception, HttpServletRequest request){
//        AppException appException = new AppException(exception);
//        appException.setPath(request.getRequestURI());
//        return ResponseEntity.status(appException.getCode())
//                .body(appException);
//    }

}

