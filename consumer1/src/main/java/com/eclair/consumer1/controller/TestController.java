package com.eclair.consumer1.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Autowired
    LoadBalancerClient loadBalancerClient;
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
    @GetMapping("/get3")
    public String test3() {
        ServiceInstance provider1 = loadBalancerClient.choose("provider1");
        if (provider1 != null) {
            System.out.println(provider1.getPort());
            return provider1.getPort()+"";
        }
        return "ssss";
    }
}
