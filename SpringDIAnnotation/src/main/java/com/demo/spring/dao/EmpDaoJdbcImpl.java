package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Employee;
@Repository
public class EmpDaoJdbcImpl implements EmpDao{

	@Override
	public String save(Employee e) {
		System.out.println("JDBC implementation");
		return "Success";
	}

}
