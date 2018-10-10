package com.demo.boot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Employee;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpDataController {
	@Autowired
	private EmpRepository repo;
	
	@RequestMapping(path="/getEmp/{id}",method=RequestMethod.GET,produces="application/json")
	public Employee findEmpById(@PathVariable("id") int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}else {
			throw new RuntimeException("No Emp found");
		}
		
	}
}
