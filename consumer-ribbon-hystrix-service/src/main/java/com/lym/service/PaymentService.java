package com.lym.service;

import com.apicommons.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * (Payment)表服务接口
 * @author makejava
 * @since 2021-09-26 13:44:42
 */
@FeignClient(value = "PROVIDED-SERVICE") //指定绑定的服务名
public interface PaymentService {
    @Deprecated
    @GetMapping(value = "/payment/{id}")
    CommonResult selectOne(@PathVariable("id") Serializable id);

    @GetMapping("/payment/all")
    CommonResult selectAll();
}

