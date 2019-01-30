package com.zc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@MapperScan(basePackages = "com.zc.mapper")
@ComponentScan(basePackages = {"com.zc.service", "com.zc.web", "com.zc.websocket"})
public class App 
{
    public static void main( String[] args )
    {

        // 启动 springboot 项目
        SpringApplication.run(App.class, args);
    }

}
