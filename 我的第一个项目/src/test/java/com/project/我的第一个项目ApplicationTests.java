package com.project;

import com.project.mapper.CommentMapper;
import com.project.mapper.DepartmentMapper;
import com.project.mapper.DutyMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.Blog;
import com.project.pojo.Comment;
import com.project.pojo.CommentExample;
import com.project.service.*;
import com.project.utill.UUIDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class 我的第一个项目ApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    DutyService dutyService;
    @Autowired
    DeptService deptService;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    IncomeService incomeService;
    @Autowired
    DutyMapper dutyMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BlogService blogService;
    @Test
    void contextLoads() throws InterruptedException {
        int i=1;
        i=i++;
        System.out.println(i);  //1
        int j=i++;
        System.out.println(i);  //2
        System.out.println(j);   //1
        int k=i+ ++i*i++;
        System.out.println(i);   //4
        System.out.println(j);   //1
        System.out.println(k);   //11

    }
}
