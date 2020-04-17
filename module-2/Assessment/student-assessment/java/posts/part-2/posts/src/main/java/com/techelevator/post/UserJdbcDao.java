package com.techelevator.post;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in
	// `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(User newUser) {
		// Implement this method to save user to database
		Scanner input = new Scanner (System.in);
		System.out.println("Enter first name: ");
		String firstName = input.nextLine();
		System.out.println("Enter last name: ");
		String lastName = input.nextLine();
		System.out.println("Enter email: ");
		String email = input.nextLine();
		System.out.println("Enter role: ");
		String role = input.nextLine();
		
		
		LocalDate currentDate = getCurrentDate();
		Date.valueOf(currentDate);
		
			String sqlInsertUser = "INSERT INTO users (first_name, last_name, email, role, created) VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sqlInsertUser, firstName , lastName, email, role, currentDate);
	}

	@Override
	public List<User> getAllUsers() {
		List <User> userList = new ArrayList<>();
		
		String sqlGetUsers = "SELECT * FROM users";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetUsers);
		
		while (query.next()) {
			userList.add(mapRowToUser(query));
		}
		
		return userList;
	}

	private User mapRowToUser(SqlRowSet results) {
		User userRow = new User();
		userRow.setId(results.getLong("id"));
		userRow.setFirstName(results.getString("first_name"));
		userRow.setLastName(results.getString("last_name"));
		userRow.setEmail(results.getString("email"));
		userRow.setRole(results.getString("role"));
		userRow.setCreated(results.getDate("created").toLocalDate());
		return userRow;
	}
	
	private LocalDate getCurrentDate() {      
		   DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");  
		   LocalDate currentDate = LocalDate.now();
		   return currentDate;
	}

}
