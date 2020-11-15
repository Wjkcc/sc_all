package com.eclair.provider1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wjk
 * @date: 2020/11/15 21:14
 **/
@RestController
public class TestController {
    @GetMapping("/getHi")
    public String getHi() {
        System.out.println("hi");
        return "hi world";
    }
}
