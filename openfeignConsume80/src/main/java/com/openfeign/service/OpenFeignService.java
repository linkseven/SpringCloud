package com.openfeign.service;

import com.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {
    @GetMapping("/payment/getPayment/{id}")
    CommonResult getResult(@PathVariable("id") Long id);

    @GetMapping("/payment/setTimeOut")
    String getOut();
}
