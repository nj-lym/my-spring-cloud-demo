package com.lym.fallback;

import com.apicommons.enums.CommonsEnum;
import com.apicommons.pojo.CommonResult;
import com.lym.service.PaymentService;
import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description feign使用hystrix 的回掉逻辑 请求成功则正常发返回数据  若不成功则返回自定义内容
 * @Auther lym
 * @Date 2021-11-29 16:26
 * @Version 1.0
 */
@Component
public class FeignHystrixFallBack implements FeignClientHystrixFallBack {
    @Override
    public CommonResult findAll() {
        return CommonResult.fail(CommonsEnum.SERVICE_FAILURE);
    }
}
