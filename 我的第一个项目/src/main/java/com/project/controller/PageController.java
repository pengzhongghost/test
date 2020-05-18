package com.project.controller;

import com.project.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page, User user){
//        int i=1/0;

//        String blog=null;
//        if (blog==null){
//            throw new NotFoundException1("博客不存在");
//        }

        return page;
    }

}
