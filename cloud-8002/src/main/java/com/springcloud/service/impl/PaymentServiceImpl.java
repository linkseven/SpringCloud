package com.springcloud.service.impl;

import com.springcloud.entity.Payment;
import com.springcloud.mapper.PaymentMapper;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper mapper;

    @Override
    public int add(Payment payment) {
        return mapper.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return mapper.getPaymentById(id);
    }
}
