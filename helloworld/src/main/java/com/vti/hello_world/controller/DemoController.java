package com.vti.hello_world.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @GetMapping()
    public String test(){
        return "Hello World 1";
    }

    @GetMapping(value = "/test2")
    public String test2(){
        return "Hello World 2";
    }
}
