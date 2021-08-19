package com.ljj.springcloud.Contorller;


import com.ljj.springcloud.Service.DeptService;
import com.ljj.springcloud.pojo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @PostMapping("/add")
    public boolean addDept( Dept dept) {
        return deptService.addDept(dept);
    }

    @HystrixCommand(fallbackMethod="hystrixGet")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        Dept result = deptService.queryById(id);
        if(result==null)
            throw new RuntimeException("没有ID为"+id+"的用户");
        return result;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
//        Thread t1 = new Thread(
//                ()-> {System.out.println("什么脸");}
//        ) ;  //练习一下lambda表达式
        return new Dept().setDeptno(id).setDname("没有对应信息 --@Hystrix").setDbSource("no this data in database");
    }
    @GetMapping("/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

}
