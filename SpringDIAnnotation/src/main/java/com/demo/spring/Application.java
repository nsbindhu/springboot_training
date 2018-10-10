package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		HrService ser =  ctx.getBean(HrService.class);
		System.out.println(ser.registerEmployee(1, "ABC", "Hyd", 10000));
	}
}
