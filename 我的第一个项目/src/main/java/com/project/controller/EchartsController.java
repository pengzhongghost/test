package com.project.controller;

import com.project.pojo.Echart;
import com.project.pojo.Income;
import com.project.pojo.IncomeDetails;
import com.project.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/EchartsController")
public class EchartsController {
    @Autowired
    IncomeService incomeService;
    @RequestMapping("/showEcharts")
    @ResponseBody
    public Object showEcharts(){
        List<IncomeDetails> incomes=incomeService.selectAll();
        HashMap<String,List> hashMap=new HashMap<>();
            hashMap.put("incomes",incomes);
        return hashMap;
    }

    @RequestMapping("/showEcharts1")
    @ResponseBody
    public Object showEcharts1(){
        List<Echart> echarts=incomeService.selectOne();
        return echarts;
    }

}
