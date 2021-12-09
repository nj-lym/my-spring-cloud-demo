package com.lym.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Auther lym
 * @Date 2021-10-14 14:19
 * @Version 1.0
 */
@Configuration
public class FeignConfig{

    @Bean
    Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }

}
