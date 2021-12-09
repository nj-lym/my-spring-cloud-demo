package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.lym.fallback.FeignClientHystrixFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Auther lym
 * @Date 2021-10-14 9:24
 * @Version 1.0
 */
@RestController
@RequestMapping("consumer")
public class ConsumerHystrixFallbackStreamController {

    @Autowired
    private FeignClientHystrixFallBack feignClientHystrixFallBack;

    /**
     * feign使用hystrix 的回掉逻辑
     */
        @GetMapping("hystrix/payment/all")
        public CommonResult findAll() {
            return feignClientHystrixFallBack.findAll();
        }

}
