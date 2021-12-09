package com.lym.fallback;


import com.apicommons.enums.CommonsEnum;
import com.apicommons.pojo.CommonResult;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther lym
 * @Date 2021-12-08 10:47
 * @Version 1.0
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<FeignClientHystrixFallBack> {

    private static final Logger log = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    /**
     * 返回适合给定原因的回退实例
     * @param throwable
     * @return
     */
    @Override
    public FeignClientHystrixFallBack create(Throwable throwable) {
        return new FeignClientHystrixFallBack() {
            @Override
            public CommonResult findAll() {
            //日志最好放在各个fallback方法中，而不要直接放在create方法中。否则在引用启动时，就会打印该日志。
                FeignClientFallbackFactory.log.info("进入到断路器回退逻辑.....原因是:", throwable);
                return CommonResult.fail(CommonsEnum.SERVICE_FAILURE);
            }
        };
    }
}
