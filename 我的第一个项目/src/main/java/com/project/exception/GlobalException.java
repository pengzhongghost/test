package com.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
@Slf4j
public class GlobalException implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        log.error("Request RUL: {}",httpServletRequest.getRequestURL());
        log.error("Exception: {}",e);
        ModelAndView mv=new ModelAndView();

        if (e instanceof NotFoundException1){
            mv.setViewName("/error/404");
        }else if (e instanceof BadCredentialsException){
            System.out.println("ok");
            mv.setViewName("/login2");
        }else {
            mv.setViewName("/error/500");
        }

        mv.addObject("error",e);
        return mv;
    }
}
