package com.demo.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Employee;
import com.demo.spring.repo.EmpRepository;
@Service
public class HrService {
	@Autowired
	private EmpRepository repo;
	
	@Transactional
	public String registerEmployee(int id,String name,String city,double salary) {
		  repo.save(new Employee(id,name,city,salary));
		  return "saved";
	}
	
	public void displayEmpInfo(int id) {
		Optional<Employee> o = repo.findById(id);
		if(o.isPresent()) {
			Employee emp = o.get();
			System.out.println(emp.toString());
		}else {
			System.out.println("Data not found");
		}
	}
	@Transactional
	public void deleteEmpInfo(int id) {
		repo.deleteById(id);
	}
	
	public void getEmployeeList() {
		repo.findAll().forEach(e->System.out.println(e.toString()));
	}
	
	public void getEmployeeWithRange(double s1,double s2) {
		repo.getEmpWithSalBetweenRange(s1,s2).forEach(e->System.out.println(e.toString()));
	}
}
