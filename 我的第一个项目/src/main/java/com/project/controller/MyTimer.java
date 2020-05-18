package com.project.controller;

import com.project.pojo.Clock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask clock = new Clock();
        SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间
        Date date=null;
        try {
            date=s.parse("2020-5-3 09:04:00");//把字符串转为时间对象
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timer.schedule(clock,date,1000*60*60*24);

    }
}
