package com.project.mapper;

import com.project.pojo.Comment;
import com.project.pojo.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByTid(Integer tid);

//    1111111111111111
    List<Comment> selectByTidAndPar(Integer tid,Integer cid);


    List<Comment> selectByTidAndParAndPar(Integer tid,Integer count);

    Comment selectByTidAndParAndPar1(Integer tid);

    int selectByTidAndParAndParCount(Integer tid);

    Comment findSeniorUid(Integer textgrade);
}