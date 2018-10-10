package com.demo.spring.dao;

import com.demo.spring.entity.Employee;

public class EmpDaoJdbcImpl implements EmpDao{

	@Override
	public String save(Employee e) {
		System.out.println("JDBC implementation");
		return "Success";
	}

}
