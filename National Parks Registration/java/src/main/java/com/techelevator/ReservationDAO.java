package com.techelevator;

import java.util.List;

public interface ReservationDAO {
	
	public List<Integer> handleReservation(int campgroundId);
	public void bookSite(int siteId, double campgroundFee);
	public double bookingFee(double campgroundFee);
}
