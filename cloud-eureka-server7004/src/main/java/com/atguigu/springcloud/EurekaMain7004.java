package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther zzyy
 * @create 2020-02-18 23:44
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7004
{
    public static void main(String[] args) {
            SpringApplication.run(EurekaMain7004.class, args);
    }
}
