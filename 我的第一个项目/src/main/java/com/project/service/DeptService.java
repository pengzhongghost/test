package com.project.service;

import com.project.pojo.Department;

import java.util.List;

public interface DeptService {

    Integer insertDept(Department dept);

    List<Department> findAllDepts();

    Department check(Department dept);

    void updateDept(Department dept);

    void deptDelete(Department dept);
}
