package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient

public class MainApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8002.class, args);
    }

}
