package com.hystrix.controller;

import com.hystrix.service.HystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HystrixController {
    @Resource
    private HystrixService service;

    @GetMapping("/hystrix/getInfo/{id}")
    public String getMessage1(@PathVariable("id") Long id){
        String info = service.getInfo(id);
        return info;
    }

    @GetMapping("/hystrix/getTimeOut/{id}")
    public String getMessage2(@PathVariable("id") Long id){
        String info = service.getTimeOut(id);
        return info;
    }
}
