package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
@EnableCircuitBreaker
public class ConsumerHystrixFallBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixFallBackApplication.class, args);
        System.out.println("---------测试Hystrix的fallback回调方法服务启动成功----------");
    }

}
