package com.jacob.springcloud.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jacob.springcloud.service.PaymentService;

import javax.annotation.Resource;

/** 
 * @version 1.0
 * @date 2020/03/06
 */
@RestController
@Slf4j
public class PaymentController {

	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOk(id);
        log.info("result={}", result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("result={}", result);
        return result;
    }

    @GetMapping("/payment/zipkin/")
    public String paymentZipkin(){
        String result  = paymentService.paymentCircuitBreaker(1);
        log.info("result={}",result);
        return result;
    }
  
    // -------服务熔断

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result  = paymentService.paymentCircuitBreaker(id);
        log.info("result={}",result);
        return result;
    }
}
