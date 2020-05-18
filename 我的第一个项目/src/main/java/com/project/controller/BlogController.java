package com.project.controller;

import com.project.config.NotIncludeSwagger;
import com.project.pojo.Blog;
import com.project.pojo.User;
import com.project.service.BlogService;
import com.project.utill.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/BlogController")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/toAddBlog")

    @ResponseBody
    public Object toAddBlog(Blog blog, HttpServletRequest req){

        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        if (user==null){
            return 5;
        }else {
            blog.setUid(user.getUid());
            Integer i=blogService.save(blog);
            return i;
        }
    }

    @RequestMapping("/BeforeAddBlog")
    public String BeforeAddBlog(HttpServletRequest req, Model model){

        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        Blog blog=null;
        if (user!=null){
            blog=blogService.beforeSave(user.getUid());
        }

            model.addAttribute("blog",blog);
        return "/blog-input";
    }

    @RequestMapping("/BlogPublish")
    @ResponseBody
    public Object BlogPublish(HttpServletRequest req, Blog blog){
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        if (user==null){
            return 5;
        }else if (blog.getText().length()<200){
            return 10;
        }else if (blog.getIntroduction().length()<100){
            return 20;
        }else {
            blog.setUid(user.getUid());
            Integer i=blogService.publish(blog);
            return i;
        }
    }

    @RequestMapping("/showBlog")
    public String showBlog(Model model,String searchinfo,String index){
        int i=1;
        if (index!=null&&index!=""){
            i=Integer.parseInt(index);
        }
        PageBean<Blog> pageBean=blogService.selectAll(searchinfo,i);
        List<Blog> list = pageBean.getList();

        model.addAttribute("pageBean",pageBean);
        return "right";
    }

    @RequestMapping("/showOneBlog")
    public String showOneBlog(Integer tid,Model model){

        Blog blog=blogService.selectByTid(tid);
        model.addAttribute("blog",blog);
        return "/blogdetail";
    }

    @RequestMapping("/starAdd")
    @ResponseBody
    public Object starAdd(Integer tid,HttpServletRequest req){
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        int count=0;
        if (user==null){
            return -10;//尚未登录
        }else {
            if (count==1){   //同一个人重复点赞
                return -20;
            }else {
                count++;
                Integer star=blogService.starAddByTid(tid);

                return star;
            }
        }
    }

    @RequestMapping("/starSub")
    @ResponseBody
    public Object starSub(Integer tid,HttpServletRequest req){
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        int count=0;
        if (user==null){
            return -10;//尚未登录
        }else {
            if (count==1){   //同一个人重复点赞
                return -20;
            }else {
                count++;
                Integer star=blogService.starSubByTid(tid);

                return star;
            }
        }
    }

    @RequestMapping("/showThreeBlogs")
    public String showThreeBlogs(Model model){
        List<Blog> blogs1=blogService.showFirstThreeBlogs();
        List<Blog> blogs2=blogService.showSecondThreeBlogs();

        model.addAttribute("blogs1",blogs1);
        model.addAttribute("blogs2",blogs2);

        return "/footer";
    }
}
