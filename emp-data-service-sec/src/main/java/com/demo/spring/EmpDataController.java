package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Employee;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpDataController {
	@Autowired
	private EmpRepository repo;
	
	@RequestMapping(path="/info",method=RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	public String info() {
		return "This is a sample REST service";
	}
	@RequestMapping(path="/emp/{id}",method=RequestMethod.GET,produces="application/json")
	public Employee findEmpById(@PathVariable("id") int id) {
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}else {
			throw new RuntimeException("No Emp found");
		}
		
	}
	
	@RequestMapping(path="emp/save",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="text/plain")
	public String addEmp(@RequestBody Employee e) {
		if(repo.existsById(e.getEmpId())) {
			return "Employee already exists";
		}else {
			repo.save(e);
			return "Employee saved successfully";
		}
	}
	
	@RequestMapping(path="emp/update",
			method=RequestMethod.PUT,
			consumes="application/json",
			produces="text/plain")
	public String updateEmp(@RequestBody Employee e) {
			repo.save(e);
			return "Employee updated successfully";
	}
	
	@RequestMapping(path="emp/delete",
			method=RequestMethod.DELETE,
			produces="text/plain")
	public String deleteEmp(@RequestParam int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Employee deleted";
		}else {
			return "Employee not found";
		}
	}
	
	@RequestMapping(path="emp/list",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE
			)
	public List<Employee> getEmpList(){
		return repo.findAll();
	}
}
