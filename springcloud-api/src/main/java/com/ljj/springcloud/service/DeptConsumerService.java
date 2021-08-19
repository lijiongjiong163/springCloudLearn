package com.ljj.springcloud.service;

import com.ljj.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptConsumerServiceFallbackFactory.class )
@RequestMapping("/dept")
public interface DeptConsumerService {
    @PostMapping("/add")
     boolean addDept(Dept dept);
    @GetMapping("/get/{id}")
     Dept queryById(@PathVariable("id") Long id);
    @GetMapping("/list")
     List<Dept> queryAll();


}
