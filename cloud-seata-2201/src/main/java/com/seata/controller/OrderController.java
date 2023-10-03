package com.seata.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.seata.domain.Order;
import com.seata.handler.MyBlockHandler;
import com.seata.handler.MyFallBack;
import com.seata.service.OrderService;
import com.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RefreshScope
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;
    @Autowired
    private DataSource dataSource;

    @PostMapping("/getInfo")
/*    @SentinelResource(value = "getInfo", blockHandlerClass = MyBlockHandler.class, blockHandler = "globalHandler",
            fallbackClass = MyFallBack.class, fallback = "globalFallBack")*/
    public String getTest(@RequestBody Order order) {
        CommonResult<Order> orderCommonResult = orderService.create(order);
        return orderCommonResult.getMessage();
    }
}
