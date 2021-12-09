package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine //启动 Turbine
public class ConsumerHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixTurbineApplication.class, args);
        System.out.println("---------使用Turbine监控多个微服务----------");
    }

}
