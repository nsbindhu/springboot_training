package com.demo.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demo.spring.entity.Employee;

public class JdbcMain2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);
		
		List<Employee> empList = jt.query("select * from emp", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
			
		});
		empList.stream().forEach(e->System.out.println(e.toString()));
		//Lambda
		Employee emp = (Employee) jt.queryForObject("select * from emp where empno="+101,(rs,rowNum)->{return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));});
		
		System.out.println(emp.toString());
		
		List<Employee> lambdaEmpList = jt.query("select * from emp where empno="+101,(rs,rowNum)->{return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));});
		System.out.println("Lambda result is :::::::");
		lambdaEmpList.stream().forEach(e->System.out.println(e.toString()));
	}
}
