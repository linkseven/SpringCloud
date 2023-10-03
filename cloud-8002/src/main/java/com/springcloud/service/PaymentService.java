package com.springcloud.service;

import com.springcloud.entity.Payment;

public interface PaymentService {
    public int add(Payment payment);
    public Payment getPaymentById(Long id);
}
