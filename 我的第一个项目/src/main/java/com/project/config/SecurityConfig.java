package com.project.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
                http.headers().frameOptions().sameOrigin();

         http.formLogin()

            .loginPage("/login2")
            .loginProcessingUrl("/UserController/login")
            //.failureForwardUrl("/login2")
                 .failureHandler(new MyAuthenticationFailueHandler("/login2.html"))
            .successForwardUrl("/index.html");


        http.authorizeRequests()
                .antMatchers("/","/css/**","/js/**","/images/**","/fonts/**","/assets/**","/lib/**","/plugins/**").permitAll()
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources", "/swagger-resources/configuration/security",
                        "/swagger-ui.html", "/webjars/**").permitAll()

                .antMatchers("/RandomServlet/random.jpg","/RandomServlet/**").permitAll()
                .antMatchers("/login2").permitAll()
                .antMatchers("/register.html").permitAll()
                .antMatchers("/error/**").permitAll()
                //.antMatchers("/index").permitAll()
                .anyRequest().authenticated();




        http.csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456"))
//                .authorities("admin");
//    }
}
