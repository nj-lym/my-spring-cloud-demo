package com.lym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description
 * @Auther lym
 * @Date 2021-09-26 9:56
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient //eureka客户端
//@MapperScan(basePackageClasses= PaymentDao.class) //该注解不能与tk的@RegisterMapper注解一起使用
public class ProvidedServiceWithAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvidedServiceWithAuthApplication.class, args);
        System.out.println("----------------带身份验证的生产服务启动成功---------------");
        System.out.println(new BCryptPasswordEncoder().encode("112233"));
    }
}
