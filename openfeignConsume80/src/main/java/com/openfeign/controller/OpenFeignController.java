package com.openfeign.controller;

import com.openfeign.service.OpenFeignService;
import com.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/openfeign")
public class OpenFeignController {
    @Resource
    private OpenFeignService service;

    @GetMapping("/getPayment/{id}")
    public CommonResult getInfo(@PathVariable("id") Long id){
        CommonResult result = service.getResult(id);
        return result;
    }

    @GetMapping("/setTimeOut")
    public String getOut() {
        String out = service.getOut();
        return out;
    }
}
