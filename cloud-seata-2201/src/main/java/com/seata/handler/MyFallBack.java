package com.seata.handler;

import com.seata.domain.Order;

public class MyFallBack {
    public static String globalFallBack(Order order){
        return "the server is down,please wait a moment...";
    }
}
