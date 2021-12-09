package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Auther lym
 * @Date 2021-11-30 10:19
 * @Version 1.0
 */
@RestController
@RequestMapping("ribbon")
public class ConsumerRibbonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRibbonController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/payment/all")
    public CommonResult findAll() {
        return this.restTemplate.getForObject("http://PROVIDED-SERVICE/payment/all", CommonResult.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("PROVIDED-SERVICE");
        // 打印当前选择的是哪个节点
        ConsumerRibbonController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
