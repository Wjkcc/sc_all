package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    public static void js() {
        JSONObject jsonObject = new JSONObject();
        String a = jsonObject.getString("ss");
        String b = JSONObject.parseArray(a).getString(1);
    }
}
