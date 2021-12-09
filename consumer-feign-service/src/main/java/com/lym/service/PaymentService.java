package com.lym.service;

import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.lym.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * (Payment)表服务接口
 * @author makejava
 * @since 2021-09-26 13:44:42
 */
@FeignClient(value = "PROVIDED-SERVICE",configuration = FeignConfig.class) //指定绑定的服务名
public interface PaymentService {

    @GetMapping("/payment/all")
    CommonResult selectAll();
}

