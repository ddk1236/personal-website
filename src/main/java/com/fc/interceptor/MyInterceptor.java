package com.fc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ddk
 * @date 2021/8/15
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /*
     * 进入controller方法之前调用
     *
     * true表示放行，false表示不放行
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        if (null != username || !"".equals(username)){
            return true;
        }
        return false;
    }

    // 调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
    // 页面跳转之后，整个流程执行之后，一般用于资源清理操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
