package com.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-8001")
public interface HystrixService {
    @GetMapping("/hystrix/getInfo/{id}")
    String getMessage1(@PathVariable("id") Long id);

    @GetMapping("/hystrix/getTimeOut/{id}")
    String getMessage2(@PathVariable("id") Long id);
}
