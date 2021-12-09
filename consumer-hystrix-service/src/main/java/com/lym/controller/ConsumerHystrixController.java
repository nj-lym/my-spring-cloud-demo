package com.lym.controller;

import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.lym.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConsumerHystrixController {

    @Autowired
    private PaymentService paymentService;


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
}
