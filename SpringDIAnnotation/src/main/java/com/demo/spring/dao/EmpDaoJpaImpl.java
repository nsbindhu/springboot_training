package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Employee;
@Repository
public class EmpDaoJpaImpl implements EmpDao{

	@Override
	public String save(Employee e) {
		System.out.println("JPA implementaion");
		return "Success";
	}

}
