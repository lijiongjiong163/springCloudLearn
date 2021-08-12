package com.ljj.springcloud.Controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ljj.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerContorller {
    //消费者不应该有Service层
    //使用restTemplate来调用其他服务的端口,提供多种便捷访问http服务的方法，简单的restful服务。
    @Autowired
    private RestTemplate restTemplate;
    //原来直接访问提供者的端口，集成ribbon后就可以通过在注册中心的应用名称来访问具体应用了
    //private final static String REST_URL_PREFIX="http://localhost:8001/dept";
    private final static String REST_URL_PREFIX="http://SPRINGCLOUD-PROVIDER-DEPT:8001/dept";

    @RequestMapping("/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/add",dept,Boolean.class);
    }
    @RequestMapping("/list")
    public List<Dept> list (){
        return restTemplate.getForObject(REST_URL_PREFIX+"/list",List.class);
    }
    @RequestMapping("/get/{id}")
    public Dept get (@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/get/"+id,Dept.class);
    }


}
