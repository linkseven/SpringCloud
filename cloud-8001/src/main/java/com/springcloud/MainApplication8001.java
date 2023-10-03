package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient //服务发现
public class MainApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication8001.class, args);
    }

}
