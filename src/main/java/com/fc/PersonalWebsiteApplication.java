package com.fc;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 声明此注解后，Servlet、Filter、Listener可以直接通过
// @WebServlet、@WebFilter、@WebListener注解自动注册
@ServletComponentScan
@SpringBootApplication
@MapperScan("com.fc.mapper")
@EnableSwagger2Doc
public class PersonalWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalWebsiteApplication.class, args);
    }

}
