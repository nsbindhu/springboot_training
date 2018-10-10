package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class JpaMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hs = ctx.getBean(HrService.class);
		
		System.out.println(hs.displayEmpInfo(106).toString());
		
		hs.getEmployeeList();
	}
}
