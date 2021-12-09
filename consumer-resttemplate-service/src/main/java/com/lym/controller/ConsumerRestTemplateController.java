package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

/**
 * @Description RestTemplate方式调用服务
 * @Auther lym
 * @Date 2021-10-12 14:05
 * @Version 1.0
 */
@RestController
@RequestMapping("consumer")
public class ConsumerRestTemplateController {

    public static final String BASE_URL = "http://PROVIDED-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("restTemplate/payment/all")
    public CommonResult queryAll() {
        return restTemplate.getForObject(BASE_URL + "payment/all", CommonResult.class);
    }

}
