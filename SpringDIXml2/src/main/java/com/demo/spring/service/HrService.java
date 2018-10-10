package com.demo.spring.service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Employee;

public class HrService {
	private EmpDao dao;
	public String registerEmployee(int id,String name,String city,double salary) {
		return dao.save(new Employee(id,name,city,salary));
	}
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
}
