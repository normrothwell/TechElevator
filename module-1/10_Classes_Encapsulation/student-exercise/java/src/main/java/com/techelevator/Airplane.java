package com.techelevator;

public class Airplane {
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int availableFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int availableCoachSeats;
	private int totalCoachSeats;
	
	public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
		this.planeNumber = planeNumber;
		this.totalFirstClassSeats = totalFirstClassSeats;
		this.totalCoachSeats = totalCoachSeats;
		this.availableFirstClassSeats = totalFirstClassSeats;
		this.availableCoachSeats = totalCoachSeats;
		
	}

	public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
		if (forFirstClass == true) {
			if (availableFirstClassSeats >= totalNumberOfSeats) {
				availableFirstClassSeats -= totalNumberOfSeats;
				bookedFirstClassSeats += totalNumberOfSeats;
				return true;
			}
		}else if (availableCoachSeats >= totalNumberOfSeats) {
			availableCoachSeats -= totalNumberOfSeats;
			bookedCoachSeats += totalNumberOfSeats;
			return true;
		}return false;
	}
	
	
	public String getPlaneNumber() {
		return planeNumber;
	}
	
	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}
	
	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
	}
	
	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}
	
	public int getBookedCoachSeats() {
		return bookedCoachSeats;
	}
	
	public int getAvailableCoachSeats() {
		return availableCoachSeats;
	}

	public int getTotalCoachSeats() {
		return totalCoachSeats;
	}
	
	


}
