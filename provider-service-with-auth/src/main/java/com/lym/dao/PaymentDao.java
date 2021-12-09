package com.lym.dao;

import com.apicommons.pojo.Payment;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;


/**
 * @Description
 * @Auther lym
 * @Date 2021-11-25 17:35
 * @Version 1.0
 */
@org.apache.ibatis.annotations.Mapper
public interface PaymentDao extends Mapper<Payment> {

}
