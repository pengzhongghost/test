package com.project.service.impl;

import com.project.pojo.User;
import com.project.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class LoginServiceImpl implements UserDetailsService {
    /**
     * 是Apache的注解，如果导入jdk的注解会出现空指针
     * */
    //@Reference
    @Autowired
    private UserService userService;
//    @Resource
//    private HttpSession session;
    @Resource
    private HttpServletRequest req;
    @Autowired
    private ServletContext servletContext;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectUserByUsername(username);

        HttpSession session = req.getSession();


        String randStr =(String) session.getAttribute("code");
        String yzm = req.getParameter("yzm");

        if (!randStr.equals(yzm)){
            throw new UsernameNotFoundException("验证码错误");
        }

        if (user==null){
            throw new UsernameNotFoundException("用户不存在");
        }else {
            session.setAttribute("user",user);
            Object obj = servletContext.getAttribute("count");
            if (obj!=null){
                int count=(int)obj;
                count=count+1;
                servletContext.setAttribute("count",count);
            }else {
                servletContext.setAttribute("count",1);
            }

        }

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(String.valueOf(user.getRight1())));
    }
}
