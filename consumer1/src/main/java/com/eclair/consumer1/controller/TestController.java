package com.eclair.consumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: wjk
 * @date: 2020/11/15 21:16
 **/
@RestController
public class TestController {
    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/conHi")
    public String getHi() {
        List<String> services = discoveryClient.getServices();
        services.forEach(e->{
            System.out.println(e);
        });
        return "";
    }

    @GetMapping("/client")
    public Object client1() {
        List<String> services = discoveryClient.getServices();
        System.out.println(services.get(1));
        List<ServiceInstance> provider = discoveryClient.getInstances(services.get(0));
        if (provider == null || provider.isEmpty()) {
            return "ssss";
        }
        provider.forEach(e->{
            URI uri = e.getUri();
            System.out.println(uri);
        });
        return provider;
    }
}
