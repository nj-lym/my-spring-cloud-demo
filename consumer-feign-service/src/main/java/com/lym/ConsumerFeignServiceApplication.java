package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
public class ConsumerFeignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignServiceApplication.class, args);
        System.out.println("---------Feign方式消费端启动成功--------");
    }

}
