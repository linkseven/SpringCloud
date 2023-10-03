package com.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sentinel.handler.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {

    @GetMapping("/test1")
    public String getTest1() throws InterruptedException {
        //Thread.sleep(3000);
        //int i = 10 /0;
        return "test1...";
    }
    @GetMapping("/test2")
    public String getTest2(){
        return "test2...";
    }

    @GetMapping("/test3")
    @SentinelResource(value = "test3", blockHandler = "getBack")
    public String getTest3(@RequestParam(value = "q1",required = false) String q1,
                           @RequestParam(value = "q2",required = false) String q2){
        return "test3...";
    }
    public String getBack(String q1, String q2, BlockException blockException){
        return "exception...";
    }

    @GetMapping("/test4")
    @SentinelResource(value = "test4", blockHandlerClass = MyBlockHandler.class,
            blockHandler = "handlerExceptionA")
    public String getTest4(){
        return "test4...";
    }
}
