package com.project.service;

import com.project.pojo.Echart;
import com.project.pojo.Income;
import com.project.pojo.IncomeDetails;

import java.util.List;

public interface IncomeService {
    List<IncomeDetails> selectAll();

    List<Echart> selectOne();

}
