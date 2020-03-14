package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 
 *  
 *
 *  
 * @version 1.0
 * @date 2020/03/06
 */
public interface PaymentService {

    String paymentInfoOk(Integer id);

    String paymentInfoTimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
