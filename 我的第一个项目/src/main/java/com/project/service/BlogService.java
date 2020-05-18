package com.project.service;

import com.project.pojo.Blog;
import com.project.utill.PageBean;

import java.util.List;

public interface BlogService {

    Integer save(Blog blog);

    Blog beforeSave(Integer uid);

    Integer publish(Blog blog);

    PageBean<Blog> selectAll(String searchinfo,Integer index);

    Blog selectByTid(Integer tid);

    Integer starAddByTid(Integer tid);

    Integer starSubByTid(Integer tid);

    List<Blog> showFirstThreeBlogs();

    List<Blog> showSecondThreeBlogs();
}
