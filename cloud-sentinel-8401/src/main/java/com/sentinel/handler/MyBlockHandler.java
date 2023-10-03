package com.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {
    public static String handlerExceptionA(BlockException blockException){
        return "handlerExceptionA...";
    }
    public static String handlerExceptionB(BlockException blockException){
        return "handlerExceptionB...";
    }
}
