package com.luchao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("登录拦截器启动");
		if(request.getSession().getAttribute("user")==null){
			System.out.println("用户未登录，拦截");
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
			
			
		}
		System.out.println("用户已登录，不拦截");
		return true;
			
			
		
		
		
		
	}
}
