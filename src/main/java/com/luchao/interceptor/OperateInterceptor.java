package com.luchao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.luchao.entity.Operate;
import com.luchao.entity.User;

public class OperateInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("操作拦截器启动");
		System.out.println("用户请求访问页面："+request.getRequestURI());
		String URI=request.getRequestURI();
		User user=(User) request.getSession().getAttribute("user");
		
		for(Operate a:user.getOperates()){
			
			if(URI.contains(a.getOperateAction())){
				System.out.println("用户有该操作权限，放过");
				return true;
			}
		}
			
		System.out.println("用户没有该操作权限，拦截");
		response.sendRedirect(request.getContextPath()+"/errors/operateerror");
		return false;
		
		
	}
}
