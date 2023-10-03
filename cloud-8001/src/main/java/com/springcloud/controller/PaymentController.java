package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @PostMapping("/add")
    public CommonResult addResult(@RequestBody Payment payment) {
        int result = service.add(payment);
        return result != 0 ? new CommonResult(200, "添加成功") : new CommonResult(404, "添加失败");
    }

    @GetMapping("/getPayment/{id}")
    public CommonResult getResult(@PathVariable("id") Long id) {
        Payment paymentById = service.getPaymentById(id);
        log.info("------参数：" + port + paymentById);
        return paymentById != null ? new CommonResult(200, "搜索成功:" + port, paymentById) : new CommonResult(404, "搜索失败");
    }

    @GetMapping("/setTimeOut")
    public String getOut(){
        try {
            Thread.sleep(3000);
            //TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
