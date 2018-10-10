package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Employee;

public interface EmpDao {
	public String save(Employee e);

	public Employee findBy(int id);
	
	public String delete(int id);
	public List<Employee> getAll();
}
