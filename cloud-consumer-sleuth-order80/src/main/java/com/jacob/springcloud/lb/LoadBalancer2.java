package com.jacob.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import java.util.List;

/**
 * @version 1.0
 * @date 2020/03/05
 */
public interface LoadBalancer2 {
	ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
