package com.fc.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ddk
 * @date 2021/8/15
 */
//此注解用于拦截控制层的所以异常
@RestControllerAdvice
public class CustomExceptionHandler {
    //此注解用于处理对应类异常
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> handlerSystemException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();

        map.put("code","500");
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());

        return map;
    }
    //测试自定义异常
    @ExceptionHandler(value = myException.class)
    public Map<String,Object> handlerMyException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();

        map.put("code","500");
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());

        return map;
    }

}
