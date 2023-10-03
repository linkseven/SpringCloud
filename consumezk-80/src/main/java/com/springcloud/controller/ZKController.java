package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumeZK")
public class ZKController {
    @Resource
    private RestTemplate template;

    private String url = "http://localhost:8004/zookeeper/getId";
    @GetMapping("/get")
    public CommonResult getById(){
        CommonResult object = template.getForObject(url, CommonResult.class);
        ResponseEntity<CommonResult> entity = template.getForEntity(url, CommonResult.class);
        //CommonResult<Payment> body = entity.getBody();
        log.info("++++++" + object);
        log.info("======" + entity);
        return object;
    }
}
