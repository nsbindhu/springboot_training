package com.demo.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Employee;
@Repository
public class EmpDaoJdbcImpl implements EmpDao{
	@Autowired
	private JdbcTemplate jt;
	@Override
	public String save(Employee e) {
		String response = "";
		try {
			int count1=jt.update(con->{
				PreparedStatement pst = con.prepareStatement("insert into emp(empno,name,address,salary) values(?,?,?,?)");
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			});
			response = "Saved successfully";
		}catch(DuplicateKeyException ex) {
			//ex.printStackTrace();
			//response = "Duplicate entry! failed to save";
			throw ex;
		}catch(DataAccessException ex) {
			ex.printStackTrace();
			response = "Failed to save";
		}
		return response;
	}

	@Override
	public List<Employee> findBy(int id) {
		return  jt.query("select * from emp where empno="+id,(rs,rowNum)->{return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));});
	}

	@Override
	public String delete(int id) {
		try {
		int count = jt.update(c->{
			PreparedStatement pst = c.prepareStatement("delete from emp where empno=?");
			pst.setInt(1, id);
			return pst;
		});
		if(count ==1) {
			return "Employee deleted";
		}else {
			return "Employee not deleted";
		}
		}catch(DataAccessException e) {
			throw e;
		}
	}
	
	public List<Employee> getAll(){
		List<Employee> empList = jt.query("select * from emp", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
			
		});
		return empList;
	}

}
