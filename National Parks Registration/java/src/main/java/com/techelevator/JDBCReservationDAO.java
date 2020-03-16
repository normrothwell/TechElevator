package com.techelevator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO implements ReservationDAO {

private JdbcTemplate jdbcTemplate;

	long daysBetween = 0;
	LocalDate fromDate = null;
	LocalDate toDate = null;
	double bookingFee = 0;
	
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public List<Integer> handleReservation(int campgroundId) {
		
		List <Integer> theReservation = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		daysBetween = 0;
		
		while (daysBetween <= 0) {
			fromDate = null;
			toDate = null;
						
			while (fromDate == null) {
				System.out.println("Please enter your arrival date in the following format: yyyymmdd: ");
				String arriveDate = input.nextLine();
				fromDate = toLocalDate(arriveDate);
			}
			while (toDate == null) {
				System.out.println("Please enter your departure date in the following format: yyyymmdd: ");
				String departDate = input.nextLine();
				toDate = toLocalDate(departDate);
			}
			daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);
			if (daysBetween <= 0) {
				System.out.println("You must stay at least one night");
			}
		}
		theReservation = getReservation(campgroundId, fromDate, toDate);
		
		return theReservation;
		
}
	
	private List<Integer> getReservation (int campgroundId, LocalDate fromDate, LocalDate toDate){
		List <Integer> sites = new ArrayList<>();
		boolean siteLoop = true;
		
		while (siteLoop) {
			String sqlGetReservation = "SELECT * from site a WHERE a.campground_id = ? AND a.site_id "
				+ "NOT IN (SELECT b.site_id from site b JOiN reservation ON reservation.reservation_id = b.site_id "
				+ "WHERE (reservation.from_date between ? AND ?) AND (reservation.to_date between ? AND ?))LIMIT 5";
			SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetReservation, campgroundId, fromDate, toDate, fromDate, toDate);
		
			while (query.next()) {
				sites.add(query.getInt("site_id"));
			}
			siteLoop = false;
		
			if (sites == null) {
				System.out.println("No sites available to book");
				siteLoop = true;
			}
		}
		return sites;
	}

	private LocalDate toLocalDate(String formatDate) {
		LocalDate date = null;
		Integer year = Integer.parseInt(formatDate.substring(0,4));
		Integer month = Integer.parseInt(formatDate.substring(4,6));
		Integer day = Integer.parseInt(formatDate.substring(6,8));
		try {
			date = LocalDate.of(year, month, day);
		} catch (DateTimeException e) {
			System.out.println("Please enter a valid date");
		}
		System.out.println(date);
		return date;
	}


	@Override
	public void bookSite(int siteId, double campgroundFee) {
		Scanner input = new Scanner(System.in);
		int bookingId = 0;
		double bookingFee = bookingFee(campgroundFee);
		System.out.println("Your fee to book this site will be $" + String.format("%.2f", bookingFee) + " Please enter a name for this reservation or 0 to cancel: ");
		String bookingName = input.nextLine();
		if (!bookingName.equals("0")){
			LocalDate currentDate = getCurrentDate();
		
			String sqlCompleteBooking = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sqlCompleteBooking, siteId, bookingName, fromDate, toDate, currentDate);
			
			String sqlGetReservationId = "SELECT reservation_id from reservation WHERE name = ? AND from_date = ? AND to_date = ?";
			SqlRowSet query = jdbcTemplate.queryForRowSet(sqlGetReservationId, bookingName, fromDate, toDate);
			if (query.next()) {
				bookingId = query.getInt("reservation_id");
			}
			System.out.println("Thank you for booking site " + siteId + "\nYour reservation number is " + bookingId);
		}
		
		
	}
	
	private LocalDate getCurrentDate() {      
		   DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");  
		   LocalDate currentDate = LocalDate.now();
		   return currentDate;
	}


	@Override
	public double bookingFee(double campgroundFee) {
		bookingFee = campgroundFee * daysBetween;
		return bookingFee;
	}



}