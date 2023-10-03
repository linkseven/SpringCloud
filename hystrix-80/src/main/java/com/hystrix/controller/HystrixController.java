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

    @GetMapping("/consume/getInfo/{id}")
    public String testInfo(@PathVariable("id") Long id){
        String message1 = service.getMessage1(id);
        return message1;
    }

    @GetMapping("/consume/getTimeOut/{id}")
    public String testTimeOut(@PathVariable("id") Long id){
        String message2 = service.getMessage2(id);
        return message2;
    }
}
