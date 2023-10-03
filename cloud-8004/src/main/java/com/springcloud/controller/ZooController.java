package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/zookeeper")
public class ZooController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/getId")
    public CommonResult<Payment> getId(){
        log.info("server port:" + port + " uuid: " + UUID.randomUUID().toString());
        return new CommonResult<>(200, "ok");
    }
}
