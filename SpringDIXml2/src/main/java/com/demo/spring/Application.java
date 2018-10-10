package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HrService;

public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		HrService ser = (HrService) ctx.getBean("hrService");
		System.out.println(ser.registerEmployee(1, "ABC", "Hyd", 10000));
	}
}
