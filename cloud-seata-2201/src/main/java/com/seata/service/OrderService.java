package com.seata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seata.domain.Order;
import com.springcloud.entity.CommonResult;

public interface OrderService extends IService<Order> {
    CommonResult<Order> create(Order order);
}
