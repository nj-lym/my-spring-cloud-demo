package com.apicommons.pojo;

import cn.hutool.http.HttpStatus;
import com.apicommons.enums.CommonsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description
 * @Auther lym
 * @Date 2021-09-23 16:05
 * @Version 1.0
 */
@Data
@NoArgsConstructor //无参构造器
@AllArgsConstructor//全部参数的构造器
@Accessors(chain = true)//生成的set方法会返回this(当前对象)
public class CommonResult {

    private String code;
    private String massage;
    private Object data;

    private static CommonResult result(String code, String massage, Object data) {
        return new CommonResult(code, massage, data);
    }

    public static CommonResult ok(Object data) {
        return result(CommonsEnum.SUCCESS.getCode(), CommonsEnum.SUCCESS.getMassage(), data);
    }

    public static CommonResult fail() {
        return result(CommonsEnum.FAIL.getCode(), CommonsEnum.FAIL.getMassage(), null);
    }
    public static CommonResult fail(CommonsEnum type) {
        return result(type.getCode(), type.getMassage(), null);
    }

    public static CommonResult fail(String code, String msg) {
        return result(code, msg, null);
    }
}
