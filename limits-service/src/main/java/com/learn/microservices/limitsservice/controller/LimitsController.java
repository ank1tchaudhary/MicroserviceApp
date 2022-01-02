package com.learn.microservices.limitsservice.controller;

import com.learn.microservices.limitsservice.bean.Limits;
import com.learn.microservices.limitsservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsConfiguration configuration;

//    @GetMapping("/test")
//    public String test(){
//        return  "Hi";
//    }

    @GetMapping("/limits")
    public Limits limits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
