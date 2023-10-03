package com.seata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seata.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    boolean create(Order order);
    boolean updateStatus(Integer status);
}
