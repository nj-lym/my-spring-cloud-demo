package com.lym.service;

import com.apicommons.pojo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * (Payment)表服务接口
 * @author makejava
 * @since 2021-09-26 13:44:42
 */

public interface PaymentService {

    @GetMapping("/payment/all")
    CommonResult selectAll();
}

