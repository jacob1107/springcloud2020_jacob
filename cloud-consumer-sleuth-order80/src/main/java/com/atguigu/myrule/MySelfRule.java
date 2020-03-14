package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @date 2020/03/05
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
