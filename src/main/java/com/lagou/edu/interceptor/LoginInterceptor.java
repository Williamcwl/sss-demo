package com.lagou.edu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor  implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler 打印出来com.mmm.controller.UserController@6225177c
     * @return
     * @throws Exception
     *
     *
     * HandlerInterceptor接口中的三个方法：
    01.preHandle 如果返回值是false,则不会执行后续的操作！ 一个拦截器
    preHandle如果返回值是true 则会执行下一个拦截器。。
    02.如果有多个拦截器，则之后拦截器中的所有方法都不会执行！
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了 拦截器1111中的 ===》preHandle");
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username == null){
            response.sendRedirect("/login.jsp");
            return false;
        }
        return true;
    }

}
