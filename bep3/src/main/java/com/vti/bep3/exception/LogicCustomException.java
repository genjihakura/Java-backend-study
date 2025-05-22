package com.vti.bep3.exception;

import lombok.Data;

@Data

public class LogicCustomException extends RuntimeException{
    private int code;
    private String message;
}
