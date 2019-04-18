package com.spring.boot.quickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
* springBoot的第一个RESTTful请求
* 2019.03.18
* */
@RestController
public class HelloController {

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String getHelllo(){
        return "Hello,Spring Boot~";
    }





}
