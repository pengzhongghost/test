package com.project.service.impl;

import com.project.mapper.DepartmentMapper;
import com.project.mapper.DutyMapper;
import com.project.mapper.UserMapper;
import com.project.pojo.Department;
import com.project.pojo.Duty;
import com.project.pojo.DutyExample;
import com.project.pojo.User;
import com.project.service.DutyService;
import com.project.utill.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DutyServiceImpl implements DutyService {
    @Autowired
    DutyMapper dutyMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    @Transactional
    public Integer signin(User user) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        Duty duty=dutyMapper.findByDateAndIntime(date,user.getId());
        if (duty!=null){
            return 3;   //已经签到
        }else {
            DateFormat sintime=new SimpleDateFormat("HH:mm:ss");
            String intime = sintime.format(new Date());
            Duty duty1=new Duty();
            duty1.setDate(date);
            duty1.setUid(user.getId());
            duty1.setIntime(intime);
            Integer i=dutyMapper.insertIntime(duty1);
            return i;
        }
    }

    @Override
    @Transactional
    public Integer signout(User user) {
        Date d=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(d);
        Duty duty=dutyMapper.findByDateAndIntime(date,user.getId());

        DateFormat hour=new SimpleDateFormat("HH");
        DateFormat minute=new SimpleDateFormat("mm");
        DateFormat second=new SimpleDateFormat("ss");
        DateFormat sintime1=new SimpleDateFormat("HH:mm:ss");
        String h = hour.format(d);
        int hour1 = Integer.parseInt(h);
        String m = minute.format(d);
        int minute1 = Integer.parseInt(m);
        String s = second.format(d);
        int second1 = Integer.parseInt(s);

        if (duty==null){
            return 3;   //尚未签到
        }else {

            Date inttime =null;
            try {
                inttime = sintime1.parse(duty.getIntime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String h2 = hour.format(inttime);
            int hour2 = Integer.parseInt(h2);
            String m2 = minute.format(inttime);

            int minute2 = Integer.parseInt(m2);
            String s2 = second.format(inttime);

            int second2 = Integer.parseInt(s2);

            if (hour1-hour2==0&&minute1-minute2==0&&second1-second2>=0){
                return 5;
            }else if (hour1-hour2==0&&minute1-minute2>=0&&minute1-minute2<11){
                return 5;
            }else {
                DateFormat sintime=new SimpleDateFormat("HH:mm:ss");
                String outtime = sintime.format(new Date());
                duty.setOuttime(outtime);
                Integer i=dutyMapper.updateOuttime(duty);
                return i;
            }
        }
    }


    @Override
    public PageBean findAllDuty(int index,String username,int did,String date) {
        int count=dutyMapper.selectCount(username,did,date);
        PageBean<Duty> pageBean=new PageBean<Duty>();

        pageBean.setTotalCount(count);
        pageBean.setIndex(index);

        int startRow = pageBean.getStartRow();
        int sendRow = pageBean.getEndRow();
        int endRow=sendRow-startRow;

        List<Duty> duties = dutyMapper.selectByExample(startRow,endRow,username,did,date);
        for (Duty duty:duties){
            User user = userMapper.selectByPrimaryKey(duty.getUid());
            Department department = departmentMapper.selectByPrimaryKey(user.getDid());
            user.setDepartment(department);
            duty.setUser(user);
        }
        int[] numbers1 = pageBean.getNumbers();
        int[] numbers = new int[3];
        if (numbers1!=null){
            if (numbers1.length>3){
                if (index-1==0){
                    numbers[0]=1;
                    numbers[1]=2;
                    numbers[2]=3;
                }else if (index+1>=pageBean.getTotalPageCount()-1){
                    numbers[0]=pageBean.getTotalPageCount()-2;
                    numbers[1]=pageBean.getTotalPageCount()-1;
                    numbers[2]=pageBean.getTotalPageCount();
                }else {
                    numbers[0]=index-1;
                    numbers[1]=index;
                    numbers[2]=index+1;
                }
                pageBean.setNumbers(numbers);
            }
        }



        pageBean.setList(duties);
        return pageBean;
    }

    @Override
    public List<Duty> findSomeDuty(List<Integer> dids) {
        List<Duty> duties=new ArrayList<Duty>();
        for (Integer i:dids){
            Duty duty = dutyMapper.selectByPrimaryKey(i);
            duties.add(duty);
        }
        for (Duty duty:duties){
            User user = userMapper.selectByPrimaryKey(duty.getUid());
            Department department = departmentMapper.selectByPrimaryKey(user.getDid());
            user.setDepartment(department);
            duty.setUser(user);
        }

        return duties;
    }

    @Override
    public PageBean<Duty> findMyDuty(Integer uid,Integer index) {
        Integer count=dutyMapper.selectCountByUid(uid);
        PageBean<Duty> pageBean=new PageBean<Duty>();
        pageBean.setIndex(index);
        pageBean.setTotalCount(count);
        int startRow = pageBean.getStartRow();
        int sendRow = pageBean.getEndRow();
        int endRow=sendRow-startRow;

        List<Duty> duties=dutyMapper.selectByUid(uid,startRow,endRow);
        pageBean.setList(duties);

        return pageBean;
    }
}
