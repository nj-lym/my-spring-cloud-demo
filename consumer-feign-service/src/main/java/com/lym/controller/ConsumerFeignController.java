package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.lym.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @Description
 * @Auther lym
 * @Date 2021-10-14 9:24
 * @Version 1.0
 */
@RestController
@RequestMapping("consumer")
public class ConsumerFeignController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignController.class);

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("feign/payment/all")
    public CommonResult queryAll() {
        return paymentService.selectAll();
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("PROVIDED-SERVICE");
        // 打印当前选择的是哪个节点
        ConsumerFeignController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
