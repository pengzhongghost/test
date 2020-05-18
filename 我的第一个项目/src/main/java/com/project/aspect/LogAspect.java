package com.project.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//切面
@Aspect
@Component
@Slf4j
public class LogAspect {


    @Pointcut("execution(* com.project.controller.*.*(..))")
    public void log(){

    }


    @Before("log()")  //log前执行
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer url = request.getRequestURL();
        String ip = request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        Object[] args=joinPoint.getArgs();

        log.info("url:{},ip:{},classMethod:{},args:{}",url,ip,classMethod,args);
    }

    @After("log()")  //log前执行
    public void doAfter(){
//        log.error("------------doAfter------------");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        log.info("Result:{}",object);
    }

}

