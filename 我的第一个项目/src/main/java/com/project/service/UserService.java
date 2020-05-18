package com.project.service;

import com.project.pojo.Department;
import com.project.pojo.Position;
import com.project.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);

    List<User> findAllStaff();

    List<Department> findAllDepartments();

    List<Position> findAllPosition();

    void staffAdd(User user);

    User findOne(int uid);

    void userUpdate(User user);

    int pwdedit(User user);

    void deleteUser(User user);

    public User selectUserByUsername(String username);

    int register(User user);
}
