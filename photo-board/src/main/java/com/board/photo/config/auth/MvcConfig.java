package com.board.photo.config.auth;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
	
	// 요청 - 뷰 연결
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("main");
	    registry.addViewController("/auth/signin").setViewName("signin");
	    registry.addViewController("/admin").setViewName("admin");
	    registry.addViewController("/auth/signup").setViewName("signup");
	}
}
