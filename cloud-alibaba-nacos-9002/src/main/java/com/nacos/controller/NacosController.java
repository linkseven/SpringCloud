package com.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class NacosController {
    @GetMapping("/nacos/getId")
    public String getInfo(){
        return UUID.randomUUID().toString();
    }
}
