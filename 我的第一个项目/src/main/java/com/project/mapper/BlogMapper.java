package com.project.mapper;

import com.project.pojo.Blog;
import com.project.pojo.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    List<Blog> selectBySome(int startRow, int endRow,String searchinfo);

    Blog selectByUid(Integer uid);

    Integer updateByUid(Blog blog);

    Integer updateByTidAndStar(Integer tid, int star);

    List<Blog> selectFirstThreeBlogs();

    List<Blog> selectSecondThreeBlogs();

    int countBySome(String searchinfo);

}