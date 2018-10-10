package com.demo.spring.dao;

import com.demo.spring.entity.Employee;

public class EmpDaoJpaImpl implements EmpDao{

	@Override
	public String save(Employee e) {
		System.out.println("JPA implementaion");
		return "Success";
	}

}
