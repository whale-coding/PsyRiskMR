package com.ahu.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: MybatisPlusConfig
 * @Date: 2024/3/9 20:15
 * @Author: 聂建强
 * @Description: mybatis-plus的配置类
 */
@Configuration
public class MybatisPlusConfig {

    // 配置mybatis-plus的分页拦截器
    @Bean
    public MybatisPlusInterceptor mpInterceptor() {
        // 1、定义MP拦截器
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        // 2、添加具体的拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceptor;
    }

}
