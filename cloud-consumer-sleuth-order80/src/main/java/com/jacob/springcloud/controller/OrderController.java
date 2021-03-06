package com.jacob.springcloud.controller;

import java.net.URI;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jacob.springcloud.entities.CommonResult;
import com.jacob.springcloud.entities.Payment;
import com.jacob.springcloud.lb.LoadBalancer2;


import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @date 2020/03/05
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";

	public static final String PAYMENT_URL = "http://CLOUD-PROVIDER-HYSTRIX-PAYMENT";
	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancer2 loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/consumer/payment/getForEntity/{id}")
	public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,
				CommonResult.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody();
		} else {
			return new CommonResult<>(444, "操作失败");
		}
	}

	@GetMapping("/consumer/payment/lb")
	public String getPaymentLb() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if (instances == null || instances.size() <= 0) {
			return null;
		}
		ServiceInstance serviceInstance = loadBalancer.instances(instances);
		URI uri = serviceInstance.getUri();
		return restTemplate.getForObject(uri + "/payment/lb", String.class);
	}

	@GetMapping("/consumer/payment/zipkin")
	public String paymentZipkin() {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/", String.class);
	}
}
