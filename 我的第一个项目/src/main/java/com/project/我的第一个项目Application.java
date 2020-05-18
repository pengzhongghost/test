package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.project.mapper")
@ServletComponentScan
@EnableSwagger2

public class 我的第一个项目Application {

    public static void main(String[] args) {
        SpringApplication.run(我的第一个项目Application.class, args);
    }

}
