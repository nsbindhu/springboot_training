package com.demo.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Employee;
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	@Query("select e from Employee e where salary between ?1 and ?2")
	public List<Employee> getEmpWithSalBetweenRange(double sal1,double sal2);
}
