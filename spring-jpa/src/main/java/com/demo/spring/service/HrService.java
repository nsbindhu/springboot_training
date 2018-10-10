package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Employee;
@Service
public class HrService {
	@Autowired
	private EmpDao dao;
	@Transactional
	public String registerEmployee(int id,String name,String city,double salary) {
		return  dao.save(new Employee(id,name,city,salary));
	}
	
	public Employee displayEmpInfo(int id) {
		return dao.findBy(id);
	}
	@Transactional
	public String deleteEmpInfo(int id) {
		return dao.delete(id);
	}
	
	public void getEmployeeList() {
		dao.getAll().forEach(e->System.out.println(e.toString()));
	}
}
