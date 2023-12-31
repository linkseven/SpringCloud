package com.nacos.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class NacosController {
    @Resource
    private RestTemplate template;
    @Value("${spring-cloud.provider-url}")
    private String url;

    @GetMapping("/client/nacos/getId")
    public String getInfo(){
        String id = template.getForObject(url + "/nacos/getId", String.class);
        return String.format("%s : %s",url,id);
    }
}
