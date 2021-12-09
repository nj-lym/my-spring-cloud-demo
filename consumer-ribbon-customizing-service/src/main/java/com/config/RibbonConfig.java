package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 该类为 Ribbon 的配直类
 * 该类不应该在主应用程 上下文的＠ComponentScan所扫描的包中
 * (SpringBoot主配置类只会扫描自己所在的包及其子包下面)
 * @Auther lym
 * @Date 2021-12-02 16:51
 * @Version 1.0
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        //负载均衡规则改为随机
        return new RandomRule();
    }
}
