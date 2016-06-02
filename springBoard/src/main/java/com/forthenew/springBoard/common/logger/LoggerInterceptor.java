package com.forthenew.springBoard.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {

	protected Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if( log.isDebugEnabled()) {
			log.debug("======================================          START         ======================================");
			log.debug(" Request URI \t:  " + request.getRequestURI());
		}
		return super.preHandle(request, response, handler);
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("======================================           END          ======================================\n");
        }
	}
}
