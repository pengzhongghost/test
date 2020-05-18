package com.project.mapper;

import com.project.pojo.Echart;
import com.project.pojo.EchartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EchartMapper {
    long countByExample(EchartExample example);

    int deleteByExample(EchartExample example);

    int deleteByPrimaryKey(String name);

    int insert(Echart record);

    int insertSelective(Echart record);

    List<Echart> selectByExample(EchartExample example);

    Echart selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Echart record, @Param("example") EchartExample example);

    int updateByExample(@Param("record") Echart record, @Param("example") EchartExample example);

    int updateByPrimaryKeySelective(Echart record);

    int updateByPrimaryKey(Echart record);
}