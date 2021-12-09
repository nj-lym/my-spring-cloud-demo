package com.lym;

import com.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
/* 书中例子是单独新建了一个TestConfiguration类 然后添加该注解 此处直接添加在启动类上
    @RibbonClient: 为某个服务指定配置类 (配置类中 指定了负载均衡的规则) 
 */
@RibbonClient(name = "PROVIDED-SERVICE", configuration = RibbonConfig.class)
public class ConsumerRibbonCustomizingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonCustomizingApplication.class, args);
        System.out.println("------------自定义负载均衡规则 启动成功----------");
    }

}
