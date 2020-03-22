package com.jacob.springcloud.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-23 17:02
 */
@RestController
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo() {
		return configInfo;
	}
}
