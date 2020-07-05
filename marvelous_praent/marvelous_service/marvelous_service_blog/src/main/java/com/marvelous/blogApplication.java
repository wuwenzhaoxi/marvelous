package com.marvelous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;



@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.marvelous.blog.dao"})
public class blogApplication {
    public static void main(String[] args) {
        SpringApplication.run( blogApplication.class);
    }
}
