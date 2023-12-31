package com.pavan.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProcessingTimeInterceptor implements HandlerInterceptor {
	 @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        long startTime = System.currentTimeMillis();
	        request.setAttribute("startTime", startTime);
//	        System.out.println("--------preHandle()--------");
	        return true; 
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	            ModelAndView modelAndView) throws Exception {
	        long startTime = (Long) request.getAttribute("startTime");
	        long endTime = System.currentTimeMillis();
	        long processingTime = endTime - startTime;
	        modelAndView.addObject("startTime",startTime);
	        modelAndView.addObject("endTime",endTime);
	        modelAndView.addObject("processingTime",processingTime);
//	        System.out.println("--------postHandle()--------");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	            Exception ex) throws Exception {
//	    	 System.out.println("--------afterCompletion()--------");
	    }
}
