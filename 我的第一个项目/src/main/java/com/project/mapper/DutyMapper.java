package com.project.mapper;

import com.project.pojo.Duty;
import com.project.pojo.DutyExample;
import java.util.List;

import com.project.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface DutyMapper {
    long countByExample(DutyExample example);

    int deleteByExample(DutyExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Duty record);

    int insertSelective(Duty record);

/**
 * 好的哦
 * */
    List<Duty> selectByExample(int startRow,int endRow,String username,int did,String date);

    Duty selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByExample(@Param("record") Duty record, @Param("example") DutyExample example);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);

    Duty findByDateAndIntime(String date,Integer id);

    Integer insertIntime(Duty duty1);

    Integer updateOuttime(Duty duty);

    List<Duty> findAllInfo();

    int selectCount(String username,int did,String date);

    List<Duty> selectByUid(Integer uid,Integer startRow,Integer endRow);

    Integer selectCountByUid(Integer uid);

}