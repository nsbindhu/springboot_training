package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Employee;
@Service
public class HrService {
	@Autowired
	@Qualifier("empDaoJpaImpl")
	private EmpDao dao;
	public String registerEmployee(int id,String name,String city,double salary) {
		return dao.save(new Employee(id,name,city,salary));
	}
	
	/*public void setDao(EmpDao dao) {
		this.dao = dao;
	}*/
}
