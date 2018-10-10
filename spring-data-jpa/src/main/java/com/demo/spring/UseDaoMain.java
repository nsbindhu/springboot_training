/*package com.demo.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.entity.Employee;
import com.demo.spring.service.HrService;

public class UseDaoMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		HrService hs = ctx.getBean(HrService.class);
		
		//System.out.println(hs.registerEmployee(110, "A", "B", 100));
		
		List<Employee> empList = hs.displayEmpInfo(110);
		if(empList.size() == 0) {
			System.out.println("Employee not found for id "+110);
		}else {
			empList.forEach(e->System.out.println(e));
		}
		
		System.out.println(hs.deleteEmpInfo(109));
		
		hs.getEmployeeList();
	}
}
*/