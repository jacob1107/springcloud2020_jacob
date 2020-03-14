package com.jacob.springcloud.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @auther zzyy
 * @create 2020-02-19 14:16
 */
@RestController
@Slf4j
public class PaymentController {

	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "/payment/zk")
	public String paymentzk() {
		String rsult = "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
		log.info("===========" + rsult);
		return rsult;
	}
}
