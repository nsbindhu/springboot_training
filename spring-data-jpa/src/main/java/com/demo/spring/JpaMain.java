package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Employee;
import com.demo.spring.service.HrService;

public class JpaMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hs = ctx.getBean(HrService.class);
		
		System.out.println(hs.registerEmployee(110,"Teja","Hyderabad",56000));
		
		hs.getEmployeeList();
		
		hs.getEmployeeWithRange(10000,40000);
	}
}
