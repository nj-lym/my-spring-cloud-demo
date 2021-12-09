package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.lym.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
public class ConsumerRibbonHystrixController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerRibbonHystrixController.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 使用 @HystrixCommand方式实现回退逻辑
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("hystrix/payment/all")
    public CommonResult queryAll() {
        return paymentService.selectAll();
    }

    public CommonResult fallback(Throwable throwable) {
        //执行回退方法并不意味着断路器已经打开
        return CommonResult.fail("20003", "服务出现故障,hystrix回调方法执行..原因是:" + throwable);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("PROVIDED-SERVICE");
        // 打印当前选择的是哪个节点
        LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
