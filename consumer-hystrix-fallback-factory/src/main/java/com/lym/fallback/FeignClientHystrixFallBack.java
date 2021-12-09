package com.lym.fallback;

import com.apicommons.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description feign方式使用hystrix的回掉属性
 * @Auther lym
 * @Date 2021-11-29 16:28
 * @Version 1.0
 */
@FeignClient(value = "PROVIDED-SERVICE",fallbackFactory = FeignClientFallbackFactory.class)
public interface FeignClientHystrixFallBack {

    @GetMapping("/payment/all")
    CommonResult findAll();

}
