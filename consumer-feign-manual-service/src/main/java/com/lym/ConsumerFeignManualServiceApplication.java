package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient

public class ConsumerFeignManualServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignManualServiceApplication.class, args);
        System.out.println("---------手动创建Feign服务启动成功--------");
    }

}
