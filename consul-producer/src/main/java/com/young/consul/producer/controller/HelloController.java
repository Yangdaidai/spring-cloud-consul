package com.young.consul.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2020 YOUNG. All rights reserved.
 *
 * @Package com.young.consul.producer.controller
 * @ClassName HelloController
 * @Description HelloController
 * @Author young
 * @Modify young
 * @Date 2020/3/18 17:42
 * @Version 1.0.0
 **/

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello consul";
    }
}