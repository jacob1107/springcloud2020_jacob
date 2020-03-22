package com.jacob.springcloud.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @auther zzyy
 * @create 2020-02-23 17:01
 */
@EnableApolloConfig
@SpringBootApplication
@EnableDiscoveryClient
public class ApolloConfigClientMain3378 {
	public static void main(String[] args) {
		SpringApplication.run(ApolloConfigClientMain3378.class, args);
	}
}
