package com.project.filter;

import com.project.pojo.User;
import org.springframework.ui.Model;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        User user =(User)session.getAttribute("user");
        DateFormat dateFormat=new SimpleDateFormat("hh");
        String format = dateFormat.format(new Date());
        String uri = req.getRequestURI();
        int hour = Integer.parseInt(format);
        if (uri.startsWith("/login")||uri.startsWith("/RandomServlet/random.jpg")) {
//            req.setAttribute("error", "本网站工作时间为早上9点到晚上6点");
//            req.getRequestDispatcher("/login").forward(req, resp);
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
//            if (hour > 7&&hour<22) {
                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                resp.sendRedirect("/login");
//            }
        }

    }
}
