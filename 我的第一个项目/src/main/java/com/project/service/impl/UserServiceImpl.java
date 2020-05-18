package com.project.service.impl;

import com.project.mapper.DepartmentMapper;
import com.project.mapper.PositionMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.*;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    PositionMapper positionMapper;
    @Override
    public User login(User user) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        UserExample userExample=new UserExample();
//        userExample.createCriteria().andUsernameEqualTo(user.getUsername());
//        List<User> users = userMapper.selectByExample(userExample);
//        System.out.println(users.get(0).getPassword());
//        System.out.println(user.getPassword());
//        System.out.println(passwordEncoder.encode(user.getPassword()));
//        if (users!=null&&passwordEncoder.matches(users.get(0).getPassword(),user.getPassword())){
//            return users.get(0);
//        }else {
//            return null;
//        }
        User user1 = userMapper.selectByNameAndPwd(user);
        return user1;
    }

    @Override
    public List<User> findAllStaff() {
        return userMapper.findAllStaff();
    }

    @Override
    public List<Department> findAllDepartments() {
        DepartmentExample departmentExample=new DepartmentExample();
        return departmentMapper.selectByExample(departmentExample);
    }

    @Override
    public List<Position> findAllPosition() {
        PositionExample positionExample=new PositionExample();
        return positionMapper.selectByExample(positionExample);
    }

    @Override
    @Transactional
    public void staffAdd(User user) {
        //{bcrypt}$2a$10$5vegkw/eh1gfDapW4BhbSOa5lITR5w8MOx1FpaCHE8Bq3ZDzhbVSa
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");

        user.setPassword("{bcrypt}"+"123456");

        userMapper.insert(user);

    }

    @Override
    public User findOne(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    @Transactional
    public void userUpdate(User user) {
        userMapper.updateByInfo(user);
    }

    @Override
    @Transactional
    public int pwdedit(User user) {
        return userMapper.pwdedit(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userMapper.deleteByPrimaryKey(user.getId());
    }

    @Override
    public User selectUserByUsername(String username) {
        /*UserExample userExample=new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);*/
        User user=userMapper.selectByName(username);

        if (user!=null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public int register(User user) {
        user.setRight1(0);
        return userMapper.insertSelective(user);
    }


}
