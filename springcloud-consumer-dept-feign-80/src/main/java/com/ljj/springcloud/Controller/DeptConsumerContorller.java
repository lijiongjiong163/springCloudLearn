package com.ljj.springcloud.Controller;

import com.ljj.springcloud.pojo.Dept;

import com.ljj.springcloud.service.DeptConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerContorller {

    @Autowired
    private DeptConsumerService service;


    @RequestMapping("/add")
    public boolean add(Dept dept){
        return service.addDept(dept);
    }
    @RequestMapping("/list")
    public List<Dept> list (){
        System.out.println("使用feign调用list");
        return service.queryAll();
    }
    @RequestMapping("/get/{id}")
    public Dept get (@PathVariable("id")Long id){
        return service.queryById(id);
    }


}
