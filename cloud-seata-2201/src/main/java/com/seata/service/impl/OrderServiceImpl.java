package com.seata.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.domain.Account;
import com.seata.domain.Order;
import com.seata.handler.MyBlockHandler;
import com.seata.handler.MyFallBack;
import com.seata.mapper.OrderMapper;
import com.seata.service.AccountService;
import com.seata.service.OrderService;
import com.seata.service.StorageService;
import com.springcloud.entity.CommonResult;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;
    Account account = new Account();

    @GlobalTransactional(rollbackFor = {Exception.class,Error.class})
    @Override
    public CommonResult<Order> create(Order order) {
        log.info("创建订单前");
        if (order != null) {
            boolean b = orderMapper.create(order);
            if (b){
                log.info("用户花费前");
                account.setUsed(order.getMoney());
                account.setUserId(order.getUserId());
                accountService.testDecrease(account);
                log.info("用户花费后");
                orderMapper.updateStatus(1);
                order.setStatus(1);
                log.info("创建订单后");
                return new CommonResult<>(200, "创建订单成功", order);
            }else {
                return new CommonResult<>(400, "创建创建失败");
            }
        } else {
            return new CommonResult<>(444, "订单为空");
        }
    }
}
