package com.lym.service;

import com.apicommons.pojo.Payment;

import java.util.List;

/**
 * (Payment)表服务接口
 * @author makejava
 * @since 2021-09-26 13:44:42
 */
public interface PaymentService {

    public List<Payment>findPaymentAll();

}

