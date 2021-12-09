package com.lym.service.impl;

import com.apicommons.pojo.Payment;
import com.lym.dao.PaymentDao;
import com.lym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description
 * @Auther lym
 * @Date 2021-11-25 17:37
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<Payment> findPaymentAll() {
        return paymentDao.selectAll();
    }
}
