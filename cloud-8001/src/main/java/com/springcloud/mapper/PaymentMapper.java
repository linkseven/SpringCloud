package com.springcloud.mapper;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {
    public int add(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
