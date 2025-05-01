package com.vti.hello_world.exception;

import lombok.Data;

@Data
public class logicCustomexception extends RuntimeException{
    private int Code;
    private String message;
}
