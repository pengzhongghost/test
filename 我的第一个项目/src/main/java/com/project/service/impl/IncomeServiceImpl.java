package com.project.service.impl;

import com.project.mapper.EchartMapper;
import com.project.mapper.IncomeMapper;
import com.project.pojo.*;
import com.project.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    IncomeMapper incomeMapper;
    @Autowired
    EchartMapper echartMapper;
    @Override
    public List<IncomeDetails> selectAll() {
        IncomeExample incomeExample=new IncomeExample();
        List<Income> incomeList = incomeMapper.selectByExample(incomeExample);

        IncomeDetails incomeDetails=null;
        List<IncomeDetails> incomeDetailsList=new ArrayList<>();
        for (Income income:incomeList){
            incomeDetails=new IncomeDetails();
            incomeDetails.setName(income.getType());
            incomeDetails.setValue(income.getAmount());
            incomeDetailsList.add(incomeDetails);
        }

        return incomeDetailsList;
    }

    @Override
    public List<Echart> selectOne() {
        EchartExample echartExample=new EchartExample();
        return echartMapper.selectByExample(echartExample);
    }
}
