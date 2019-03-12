package com.xwl.capatcity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/query/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
