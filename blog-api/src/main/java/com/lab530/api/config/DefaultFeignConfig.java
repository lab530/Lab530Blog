package com.lab530.api.config;


import com.lab530.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;


// 默认的Feign配置类
public class DefaultFeignConfig {
    // 配置Feign的日志级别为FULL
    @Bean
    public Logger.Level feignloggerLevel() {
        return Logger.Level.FULL;
    }

    // 创建用户信息拦截器
    @Bean
    public RequestInterceptor userInfoInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                Long userId = UserContext.getUser();
                if (userId != null) {
                    requestTemplate.header("user-info", userId.toString());
                }
            }
        };
    }
//    @Bean
//    public ItemClientFallbackFactory itemClientFallbackFactory() {
//        return new ItemClientFallbackFactory();
//    }
}
