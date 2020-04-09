package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCEmployeeDAO implements employeeDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List <Employee> allEmployees = new ArrayList<>();
		String sqlGetEmployees = "SELECT * FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployees);
		while (results.next()) {
			allEmployees.add(mapRowToEmployee(results));
		}
		return allEmployees;
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee = new Employee();
		
		theEmployee.setFirstName(results.getString("firstName"));
		theEmployee.setLastName(results.getString("lastName"));
		theEmployee.setContactEmail(results.getString("contactEmail"));
		theEmployee.setCompanyEmail(results.getString("companyEmail"));
		theEmployee.setBirthDate(results.getString("birthDate"));
		theEmployee.setHiredDate(results.getString("hiredDate"));
		
		return theEmployee;
	}

	@Override
	public void addNewEmployee(Employee theEmployee) {
		String sqlAddEmployee = "INSERT INTO employee (firstname, lastname,  contactemail, companyemail, birthdate, hireddate) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlAddEmployee, theEmployee.getFirstName(), theEmployee.getLastName(), theEmployee.getContactEmail(), theEmployee.getCompanyEmail(), theEmployee.getBirthDate(), theEmployee.getHiredDate());		
	}
		

}
