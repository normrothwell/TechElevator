package com.techelevator;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
	
public Employee (int employeeId, String firstName, String lastName, double salary) {
	this.annualSalary = salary;
	this.employeeId = employeeId;
	this.firstName = firstName;
	this.lastName = lastName;
	fullName = (lastName + ", " + firstName);
	
}



public void raiseSalary(double percent) {
	annualSalary = ((1+(.01*percent))*annualSalary);
}
	
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getFullName() {
		return fullName;
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	

}
