package com.project.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationFailueHandler implements AuthenticationFailureHandler {

    private String url;
    public MyAuthenticationFailueHandler(String url) {
        this.url=url;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        if (e instanceof UsernameNotFoundException){
            System.out.println(e.toString());
        }else {
            System.out.println(e.toString());
        }

            req.setAttribute("error","登录失败");
            req.getRequestDispatcher(url).forward(req,resp);
        //resp.getWriter().print("登录失败");
        //resp.sendRedirect(url);
    }
}
