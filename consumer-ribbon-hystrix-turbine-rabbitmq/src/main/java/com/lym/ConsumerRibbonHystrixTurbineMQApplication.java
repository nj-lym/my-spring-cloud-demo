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
public class ConsumerRibbonHystrixTurbineMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonHystrixTurbineMQApplication.class, args);
        System.out.println("--------- 使用消息中间件(RabbitMQ)收集数据之改造RibbonHystrixService服务 --------");
    }

}
