package com.femtoapp.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.femtoapp.pojo.User;
import com.femtoapp.pojo.User_Auths;

public class LoginInterceptors implements HandlerInterceptor{

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {

		//��ȡurl
		//�ж�url�Ƿ��ǹ�����ַ  ʵ�ʿ���������ַҪ�����������ļ���
		String url=request.getRequestURI();
		//���url��login.action����
		if(url.indexOf("login.action")>=0||url.indexOf("register.action")>=0||url.indexOf("client.action")>=0){
			
			return true;
		}
		HttpSession session = request.getSession();
		User_Auths user=(User_Auths) session.getAttribute("user");
		//�û���½����
		 if(user!=null){
			 
			 return true;
		 }
		 
		 //ִ�е��� ˵����Ҫ��½
		 request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
		return false;
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
