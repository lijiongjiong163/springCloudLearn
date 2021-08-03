package com.ljj.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor//无参构造
@Accessors(chain=true)//链式写法
public class Dept implements Serializable { //必须实现序列化接口
    private Long deptno;
    private String dname;
    private String dbSource;//记录这条数据存在哪个数据库中（微服务一个应用对应一个数据库）

    public Dept(String dname) {
        this.dname = dname;
    }
}
