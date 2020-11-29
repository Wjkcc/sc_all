package com.eclair.provider1.controller;

import com.eclair.provider1.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wjk
 * @date: 2020/11/15 21:14
 **/
@RestController
public class TestController {
    @Autowired
    HealthCheckService healthCheckService;
    @GetMapping("/getHi")
    public String getHi() {
        System.out.println("hi");
        return "hi world";
    }
    @GetMapping("/health")
    public String health(boolean status) {
        healthCheckService.setStatus(status);
        return "ok";
    }
}
