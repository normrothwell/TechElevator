package com.techelevator;

import java.sql.Connection;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;

public class JdbcExampleFromScratch {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setURL("jdbc:postgres://localhost:5432//dvdstore");
		dataSource.setUser("postgres");
		dataSource.setPassword("postgres1");
		Connection conn1 = dataSource.getConnection();
		Statement stmt = conn1.createStatement();
	}

}
