package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class ConsumerHystrixTurbineRabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixTurbineRabbitMQApplication.class, args);
        System.out.println("---------使用Turbine监控多个改造为使用RabbitMQ后的微服务----------");
    }

}
