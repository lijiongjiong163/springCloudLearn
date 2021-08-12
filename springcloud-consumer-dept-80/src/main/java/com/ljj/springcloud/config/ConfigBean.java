package com.ljj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //给容器中加入restTemplate
    @Bean
    @LoadBalanced //加个这个注解就可以实现ribbon负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
