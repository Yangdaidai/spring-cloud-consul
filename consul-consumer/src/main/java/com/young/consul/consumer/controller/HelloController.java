package com.young.consul.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.consul.consumer.controller
 * @ClassName HelloController
 * @Description HelloController
 * @Author young
 * @Modify young
 * @Date 2020/3/18 17:42
 * @Version 1.0.0
 **/

@Slf4j
@RestController
public class HelloController {

    @Resource
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        log.info("服务地址: {}",serviceInstance.getUri());
        log.info("服务名称: {}",serviceInstance.getServiceId());
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        log.info("result: {}",callServiceResult);

        return callServiceResult;
    }
}