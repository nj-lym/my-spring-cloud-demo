package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.lym.service.PaymentService;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @Description
 * @Auther lym
 * @Date 2021-10-14 9:24
 * @Version 1.0
 */
@Import(FeignClientsConfiguration.class) //导入spring cloud 为feign 默认提供的配置类
@RestController
@RequestMapping("consumer")
public class ConsumerFeignController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerFeignController.class);

    private PaymentService userFeginClient;

    private PaymentService adminFeginClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("PROVIDED-SERVICE");
        // 打印当前选择的是哪个节点
        ConsumerFeignController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    /**
     *  通过构造器 给userFeginClient 和 adminFeginClient绑定请求的服务 相当于起到 注入bean的作用
     * @param decoder
     * @param encoder
     * @param client
     * @param contract
     */
    @Autowired
    public ConsumerFeignController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
        this.userFeginClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("user", "123")).target(PaymentService.class, "http://PROVIDED-SERVICE/");
        this.adminFeginClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).requestInterceptor(new BasicAuthRequestInterceptor("lym", "123")).target(PaymentService.class, "http://PROVIDED-SERVICE/");
    }

    /*
    userFeginClient  登录账号 user
    adminFeginClient 登录账号 admin
    它们使用的
    同一个接口 PaymentService
     */
    @GetMapping("user/payment/all")
    public CommonResult userQueryAll() {
        return this.userFeginClient.selectAll();
    }

    @GetMapping("admin/payment/all")
    public CommonResult adminQueryAll() {

        return this.adminFeginClient.selectAll();
    }


}
