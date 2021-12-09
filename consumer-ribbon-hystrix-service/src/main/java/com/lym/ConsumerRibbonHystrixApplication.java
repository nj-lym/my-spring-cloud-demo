package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
@EnableHystrix  //启动hystrix
public class ConsumerRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonHystrixApplication.class, args);
        System.out.println("--------- 通用方式整合断路器Hystrix --------");
    }

}
