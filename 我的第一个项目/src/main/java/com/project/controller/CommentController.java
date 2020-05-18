package com.project.controller;

import com.project.pojo.Comment;
import com.project.pojo.User;
import com.project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/CommentController")
public class CommentController {

    @Autowired
    CommentService commentService;
    @RequestMapping("/commentAdd")
    @ResponseBody
    public Object commentAdd(HttpServletRequest req, Comment comment){
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        System.out.println();
        if (user==null){
            return 20;
        }else {
            int i=commentService.commentAdd(comment);

            return i;
        }
    }
}
