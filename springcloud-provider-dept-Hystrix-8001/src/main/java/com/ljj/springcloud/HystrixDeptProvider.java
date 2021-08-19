package com.ljj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = "com.ljj.springcloud")
@EnableEurekaClient
@EnableCircuitBreaker  //添加对熔断的支撑
public class HystrixDeptProvider {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDeptProvider.class,args);
    }
}
