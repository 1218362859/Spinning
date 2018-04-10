package com.femtoapp.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//全局异常解析器
public class SpinningExceptionResolver  implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object hander, Exception ex) {
	
		SpinningException SpinningException=null;
		
		if(ex instanceof SpinningException){
			SpinningException=(SpinningException) ex;
		}else{
			SpinningException=new SpinningException("服务器忙");
			
		}
		String  message=SpinningException.getMessage();
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message",message);
		
		modelAndView.setViewName("/error.jsp");
		
		return modelAndView;
	}

}
