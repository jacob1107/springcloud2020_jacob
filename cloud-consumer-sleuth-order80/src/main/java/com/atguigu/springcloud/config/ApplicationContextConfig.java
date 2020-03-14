package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 
 *  
 *
 *  
 * @version 1.0
 * @date 2020/03/05
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   // 测试自定义算法时记得注释
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
