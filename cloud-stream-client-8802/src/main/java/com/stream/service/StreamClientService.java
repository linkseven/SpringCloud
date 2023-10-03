package com.stream.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class StreamClientService {
    @Bean
    public Consumer<String> linkChannel(){
        return message -> log.info("消息：{}", message);
    }
}
