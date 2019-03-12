package com.xwl.capacity.controller;

import com.xwl.capacity.config.ConfigCenterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    ConfigCenterData data;

    @RequestMapping("/query/xwl/hello")
    public String hello(){
        return "hello,"+data.getName();
    }
}
