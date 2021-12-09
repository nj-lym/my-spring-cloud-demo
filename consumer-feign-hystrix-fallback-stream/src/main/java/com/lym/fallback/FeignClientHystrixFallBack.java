package com.lym.fallback;

import com.apicommons.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * @Description feign方式使用hystrix的回掉属性
 * @Auther lym
 * @Date 2021-11-29 16:28
 * @Version 1.0
 */
@FeignClient(value = "PROVIDED-SERVICE",fallback = FeignHystrixFallBack.class)
public interface FeignClientHystrixFallBack {

    @GetMapping("/payment/all")
    CommonResult findAll();

}
