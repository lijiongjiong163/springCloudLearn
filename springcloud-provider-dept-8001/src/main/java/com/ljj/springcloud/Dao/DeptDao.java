package com.ljj.springcloud.Dao;

import com.ljj.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept queryById(@Param("deptno") Long id);

    List<Dept> queryAll();

}
