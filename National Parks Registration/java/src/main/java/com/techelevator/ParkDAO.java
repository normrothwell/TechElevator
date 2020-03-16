package com.techelevator;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface ParkDAO {

	public List<Park> getAllParks();
	public Park findParkByName(String choice);
	public void printParkInformation(Park thePark);
}
