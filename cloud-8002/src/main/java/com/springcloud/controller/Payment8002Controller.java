package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class Payment8002Controller {
    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/getInfo")
    public Object getDiscoveryInfo() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("======" + s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("======" + instance);
        }
        return instances;
    }
}
