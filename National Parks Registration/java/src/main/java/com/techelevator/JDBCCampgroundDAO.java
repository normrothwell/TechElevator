package com.techelevator;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCampgroundDAO implements CampgroundDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCampgroundDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Campground> listAllCampgrounds(int parkId){
		
		List <Campground> allCampgrounds = new ArrayList<>();
		String sqlGetCampgrounds = "SELECT * FROM campground WHERE park_id = ? ";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetCampgrounds, parkId);
		
		while (query.next()) {
			allCampgrounds.add(mapRowToCampground(query));
		}
		
		return allCampgrounds;
	}

	private Campground mapRowToCampground (SqlRowSet query) {
		Campground theCampground = new Campground();
		theCampground.setCampgroundId(query.getInt("campground_id"));
		theCampground.setParkId(query.getInt("park_id"));
		theCampground.setCampgroundName(query.getString("name"));
		theCampground.setOpenMonth(query.getString("open_from_mm"));
		theCampground.setCloseMonth(query.getString("open_to_mm"));
		theCampground.setDailyFee(query.getDouble("daily_fee"));
		return theCampground;
	}
	
	public void printCampgroundInformation(Campground theCampground) {
		
		int campgroundIdNumber = theCampground.getCampgroundId();
		int campgroundParkId = theCampground.getParkId();
		String campName = theCampground.getCampgroundName();
		String campOpens = String.valueOf(theCampground.getOpenMonth());
		String campCloses = String.valueOf(theCampground.getCloseMonth());
		double campFee = theCampground.getDailyFee();
		String feeFee = "$"+ campFee +"0";
		
		int openMonth = Integer.parseInt(campOpens);
		int closeMonth = Integer.parseInt(campCloses);
		String opens = Month.of(openMonth).name();
		String closes = Month.of(closeMonth).name();		
		
		System.out.printf("%-4d %-31s %-15s %-15s %8s\n",campgroundIdNumber, campName, opens, closes, feeFee);
	}

	@Override
	public double getFee(int campgroundId) {
		double dailyFee = 0;
		String sqlGetCampgrounds = "SELECT daily_fee FROM campground WHERE campground_id = ? ";
		SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetCampgrounds, campgroundId);
		
		while (query.next()) {
			dailyFee = query.getDouble("daily_fee");
		}
		
		return dailyFee;
	}
	
	

	

}
