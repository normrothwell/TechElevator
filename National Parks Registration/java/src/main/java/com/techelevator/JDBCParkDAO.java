package com.techelevator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks(){
		List <Park> allParks = new ArrayList<>();
		String sqlGetParks = "SELECT * FROM park";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetParks);
		
		while (query.next()) {
			allParks.add(mapRowToPark(query));
		}
		
		return allParks;
	}
	
	@Override
	public Park findParkByName(String choice) {
		Park thePark = new Park();
		thePark = null;
		String sqlGetParkByName = "SELECT * FROM park WHERE name = ?";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetParkByName, choice);
		
		if (query.next()) {
			thePark = mapRowToPark(query);
		}
		return thePark;
	}

	private Park mapRowToPark(SqlRowSet query) {
		Park thePark = new Park();
		thePark.setParkId(query.getInt("park_id"));
		thePark.setParkName(query.getString("name"));
		thePark.setParkLocation(query.getString("location"));
		thePark.setParkArea(query.getInt("area"));
		thePark.setParkAttendance(query.getInt("visitors"));
		thePark.setParkDescription(query.getString("description"));
		
		String fullDate = query.getString("establish_date");
		Integer year = Integer.parseInt(fullDate.substring(0, 4));
		Integer month = Integer.parseInt(fullDate.substring(5, 7));
		Integer day = Integer.parseInt(fullDate.substring(8));
		LocalDate localDate = LocalDate.of(year, month, day);
		thePark.setParkEstablish(localDate);
		
		return thePark;
	}
	
	
	public void wordBox(String words) {
		System.out.println();
		int wordCount = 0;
		boolean word = false;
		int endOfLine = words.length();
		for (int x = 0; x< words.length(); x++) {
			if (Character.isLetter(words.charAt(x)) && x != endOfLine) {
				word = true;
			}else if (!Character.isLetter(words.charAt(x)) && word) {
				wordCount++;
				word = false;
			}else if (Character.isLetter(words.charAt(x)) && x == endOfLine) {
				wordCount++;
			}
		}
		
	    int count = 1;
	    for (int i = 0; 0 < wordCount; i++){
	    try{
	    	if ((words.charAt(i) == ' ') && (((count++) % 10) == 0)) {
	    		System.out.println();
	    		wordCount = wordCount - 10;
	    	}
	    else { 
	        System.out.print(words.charAt(i));
	    }
	    }catch (Exception e) {
	    	break;
	    }
	    }
	    System.out.println();
	}
	
	@Override
	public void printParkInformation(Park thePark) {
		
		int parkAttendance = thePark.getParkAttendance();
		int parkArea = thePark.getParkArea();
		String parkDescription = thePark.getParkDescription();
		
		System.out.println("***Park Information Screen***");
		System.out.println(thePark.getParkName());
		System.out.printf("Location:  \t " + thePark.getParkLocation() +"\n");
		System.out.printf("Established:  \t " + thePark.getParkEstablish()+ "\n" );
		System.out.printf("Area:  \t\t " + "%,d",parkArea );
		System.out.print(" sq mi\n");
		System.out.printf("Annual Visitors: " + "%,d\n",parkAttendance);
		
		wordBox(parkDescription);
		}
	
}
