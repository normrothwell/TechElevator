package com.techelevator;

import java.util.List;

public interface CampgroundDAO {
	public List<Campground> listAllCampgrounds(int parkId);
	public double getFee(int campgroundId);
	public void printCampgroundInformation (Campground theCampground);
}
