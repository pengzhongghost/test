package com.project.service;

import com.project.pojo.Duty;
import com.project.pojo.User;
import com.project.utill.PageBean;

import java.util.List;

public interface DutyService {
    Integer signin(User user);

    Integer signout(User user);

    PageBean findAllDuty(int index,String username,int did,String date);

    List<Duty> findSomeDuty(List<Integer> dids);

    PageBean<Duty> findMyDuty(Integer uid,Integer index);

}
