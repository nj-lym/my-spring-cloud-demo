package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//激活Feign的注解  需要加到主启动类上
//@EnableHystrix  //启动hystrix
public class ConsumerHystrixFallBackFactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixFallBackFactoryApplication.class, args);
        System.out.println("---------通过 Fallback Factory 检查回退原因的 服务启动成功----------");
    }

}
