package com.ljj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "com.ljj.springcloud")
@EnableEurekaClient
public class DeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer.class,args);
    }
}
