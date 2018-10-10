package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Employee;
@Repository
@Transactional
public class EmpDaoJPAImpl implements EmpDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Employee e) {
		em.persist(e);
		return "Employee saved successfully";
	}

	@Override
	public Employee findBy(int id) {
		Employee e = em.find(Employee.class, id);
		return e;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		Query query = em.createQuery("select e from Employee e");
		return query.getResultList();
	}

}
