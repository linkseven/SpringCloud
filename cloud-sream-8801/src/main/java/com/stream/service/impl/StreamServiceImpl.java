package com.stream.service.impl;

import cn.hutool.core.util.IdUtil;
import com.stream.service.StreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

//@EnableBinding(Source.class)    //定义消息推送管道，已废弃
@Service
public class StreamServiceImpl implements StreamService {
    @Autowired
    private StreamBridge output;

    @Override
    public String send() {
        //String uuid = UUID.randomUUID().toString();
        String s = IdUtil.fastSimpleUUID();
        output.send("linkChannel-out-0", MessageBuilder.withPayload(s).build());
        System.out.println("uuid:" + s);
        return "ok";
    }
}
