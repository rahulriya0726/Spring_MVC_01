package com.rt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rt.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate template;

	public boolean register(Employee e, String user) {

		try {

			Object[] args = { e.getName(), e.getEmailId(), e.getMobile(), e.getCity(), e.getState(), e.getAddress(),user };
			int a = template.update(
					"insert into employeedata_spring(`name`,`emailId`,`mobile`,`city`,`state`,`address`,`user_id`) values(?,?,?,?,?,?,?)",
					args);

			if (a == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e2) {

		}
		return false;
	}

	public boolean update(Employee e) {

		try {

			Object[] args = { e.getName(), e.getEmailId(), e.getMobile(), e.getCity(), e.getState(), e.getAddress(),
					e.getId() };
			int a = template.update(
					"update employeedata_spring set name = ?, emailId = ?, mobile = ?, city = ?, state = ?, address = ? where id = ?",
					args);

			if (a == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e2) {

		}
		return false;
	}

	public Employee selectEmployeeById(int id) {
		Employee e = null;
		try {

			Object[] args = { id };
			 e = template.queryForObject("select * from employeedata_spring where id = ?", args, new EmployeeRowMapper());

		} catch (Exception e2) {

		}
		return e;

	}

	public List<Employee> selectAllEmployees(String user) {
		List<Employee> list = null;
		try {
			 Object[] args = { user };
			 list = template.query("select * from employeedata_spring where user_id = ?",args, new EmployeeRowMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
