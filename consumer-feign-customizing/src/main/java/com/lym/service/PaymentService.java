package com.lym.service;

import com.apicommons.pojo.CommonResult;
import com.config.FeignConfig;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * (Payment)表服务接口
 *  使用@FeignClient的configuration属性，指定feign的配置类。
 * @author makejava
 * @since 2021-09-26 13:44:42
 */
@FeignClient(value = "PROVIDED-SERVICE",configuration = FeignConfig.class) //指定绑定的服务名
public interface PaymentService {
    /**
     * 使用feign自带的注解@RequestLine
     * GET 必须得大写 小写会抛异常
     * @return
     */
    @RequestLine("GET /payment/all")
    CommonResult selectAll();
}

