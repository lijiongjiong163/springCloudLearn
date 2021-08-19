package com.ljj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan(basePackages = "com.ljj.springcloud")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ljj.springcloud.service"} )
public class FeignDeptConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer.class,args);
    }
}
