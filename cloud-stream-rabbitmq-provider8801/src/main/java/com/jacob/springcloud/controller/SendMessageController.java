package com.jacob.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacob.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-22 11:17
 */
@RestController
public class SendMessageController {
	@Resource
	private IMessageProvider messageProvider;

	@GetMapping(value = "/sendMessage")
	public String sendMessage() {
		return messageProvider.send();
	}

}
