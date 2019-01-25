package com.zc.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //声明 Rest 风格的控制器
@EnableAutoConfiguration // 自动配置，相当于写了 spring 的配置文件
public class HelloController {

    @RequestMapping("hello/{name}")
    @ResponseBody
    public String hello(@PathVariable("name") String name) {
        return name+"Hello, Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class);
    }
}
