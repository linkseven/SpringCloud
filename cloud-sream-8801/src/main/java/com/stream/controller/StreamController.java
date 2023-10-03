package com.stream.controller;

import com.stream.service.StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamController {
    @Resource
    private StreamService streamService;

    @GetMapping("/sendMsg")
    public String getInfo(){
        return streamService.send();
    }
}
