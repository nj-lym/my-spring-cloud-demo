package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerRestTemplateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRestTemplateServiceApplication.class, args);
        System.out.println("------------消费服务RestTemplate启动成功----------");
    }

}
