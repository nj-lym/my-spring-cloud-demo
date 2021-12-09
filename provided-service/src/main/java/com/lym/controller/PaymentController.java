package com.lym.controller;


import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.lym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Payment)表控制层
 * @author makejava
 * @since 2021-09-26 13:44:37
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/all")
    public CommonResult findPaymentAll() {
        List<Payment> list = paymentService.findPaymentAll();
        return CommonResult.ok(list);
    }
}

