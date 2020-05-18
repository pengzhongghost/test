package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.controller"))
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))     //这个注解代表不被出现
                .paths(PathSelectors.regex("/people/.*"))      //正则  只有/people开头的才会出现
                //.paths(or(PathSelectors.regex("/people/.*"),PathSelectors.regex("/BlogController/.*")))
                .build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("第一个Swagger的标题")
                .description("这里是描述").version("2.0.0")
                .contact(new Contact("吆西","http://www.baidu.com","xxxx@qq.com")).build();
    }
}
