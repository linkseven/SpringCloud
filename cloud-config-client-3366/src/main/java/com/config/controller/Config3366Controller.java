package com.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class Config3366Controller {
    @Value("${application.name}")
    private String name;

    @GetMapping("/getName")
    public String getInfo() {
        log.info(name);
        return name;
    }
}
