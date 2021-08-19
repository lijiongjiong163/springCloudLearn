package com.ljj.springcloud.service;

import com.ljj.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptConsumerServiceFallbackFactory implements FallbackFactory {
    public DeptConsumerService create(Throwable throwable) {
        return new DeptConsumerService() {

            public boolean addDept(Dept dept) {
                return false;
            }

            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("该服务已经降级")
                        .setDbSource("没有数据");
            }

            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
