package com.techelevator;

import java.util.List;

public interface SiteDAO {
	public List<Site> getAvailableReservations(List<Integer> sites, double campgroundFee);
	public void printSiteInformation (Site theSite, double bookingFee);
}
