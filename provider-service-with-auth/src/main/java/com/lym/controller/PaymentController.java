package com.lym.controller;


import com.apicommons.enums.CommonsEnum;
import com.apicommons.pojo.CommonResult;
import com.apicommons.pojo.Payment;
import com.lym.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Collection;
import java.util.List;

/**
 * (Payment)表控制层
 * @author makejava
 * @since 2021-09-26 13:44:37
 */
@Slf4j
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
        String role = "";
        //获取当前经过身份验证的主体或身份验证请求令牌
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            //获取权限集
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            //遍历权限集合
            for (GrantedAuthority authority : collection) {
                role = authority.getAuthority();
                log.info("当前用户是:{}.角色是:{}", user.getUsername(), authority.getAuthority());
            }
        }
        if (role.equals("admin-role")){
            List<Payment> list = paymentService.findPaymentAll();
            return CommonResult.ok(list);
        }else {
            log.info("------------用户未授予访问权限------------");
            return CommonResult.fail(CommonsEnum.NO_AUTHORITY);
        }
    }
}

