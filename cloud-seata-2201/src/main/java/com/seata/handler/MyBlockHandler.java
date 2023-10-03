package com.seata.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.seata.domain.Order;

public class MyBlockHandler {
    public static String globalHandler(Order order, BlockException blockException){
        return "you are blocked,please wait a moment...";
    }
}
