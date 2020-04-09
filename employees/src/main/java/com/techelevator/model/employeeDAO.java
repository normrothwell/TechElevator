package com.techelevator.model;

import java.util.List;

public interface employeeDAO {
	
	List<Employee> getAllEmployees();
	void addNewEmployee(Employee theEmployee);
	
}
