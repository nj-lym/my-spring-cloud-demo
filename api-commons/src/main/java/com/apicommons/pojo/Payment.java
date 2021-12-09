package com.apicommons.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description
 * @Auther lym
 * @Date 2021-09-23 15:57
 * @Version 1.0
 */
@Data
@NoArgsConstructor //无参构造器
@AllArgsConstructor//全部参数的构造器
@Accessors(chain = true)//生成的set方法会返回this(当前对象)
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
