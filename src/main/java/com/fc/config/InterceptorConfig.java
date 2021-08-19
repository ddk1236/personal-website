package com.fc.config;

import com.fc.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author ddk
 * @date 2021/8/15
 * 创建拦截器配置类，这里的操作就相当于 SpringMVC 的注册拦截器 ，
 * @Configuration就相当于一个 springMvc.xml
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptor = registry.addInterceptor(new MyInterceptor());
        interceptor.addPathPatterns("/index.html");
        interceptor.addPathPatterns("/index");
//        interceptor.excludePathPatterns("/**");
    }
}
