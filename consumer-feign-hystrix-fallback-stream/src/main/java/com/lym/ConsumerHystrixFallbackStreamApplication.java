package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerHystrixFallbackStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixFallbackStreamApplication.class, args);
        System.out.println("--------- Hystrix 监控服务启动成功----------");
    }

}
