package com.ljj.springcloud.Contorller;


import com.ljj.springcloud.Service.DeptService;
import com.ljj.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }
    @GetMapping("/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

}
