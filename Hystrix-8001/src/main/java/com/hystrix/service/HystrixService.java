package com.hystrix.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {
    public String getInfo(Long id){
        return String.format("%s ","getInfo message: " + id);
    }

    public String getTimeOut(Long id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("%s ","getTimeOut message" + id);
    }
}
