package com.project.service.impl;

import com.project.mapper.DepartmentMapper;
import com.project.pojo.Department;
import com.project.pojo.DepartmentExample;
import com.project.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    @Transactional
    public Integer insertDept(Department dept) {
        Department department=departmentMapper.selectByIdAndName(dept);
        if (department!=null){
            return 3;
        }else {
            int i = departmentMapper.insert(dept);
            return i;
        }
    }

    @Override
    public List<Department> findAllDepts() {
        DepartmentExample departmentExample=new DepartmentExample();
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public Department check(Department dept) {
        Department department=departmentMapper.check(dept);

        return departmentMapper.check(dept);
    }

    @Override
    @Transactional
    public void updateDept(Department dept) {
        departmentMapper.updateByPrimaryKey(dept);
    }

    @Override
    @Transactional
    public void deptDelete(Department dept) {
        departmentMapper.deleteByPrimaryKey(dept.getDeptid());
    }
}
