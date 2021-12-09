package com.lym.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther lym
 * @Date 2021-12-06 15:28
 * @Version 1.0
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {


    /**
     * 模拟两个用户
     * 账号: user  密码: 123456  角色: user-role
     * 账号: lym  密码: 123456  角色: admin-role
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if ("user".equals(s)) {
            return new CustomSecurityUser("user","123", "user-role");
        } else if ("lym".equals(s)) {
            return new CustomSecurityUser("lym","123" , "admin-role");
        } else {
            return new CustomSecurityUser("admin","123","");
        }
    }
}
