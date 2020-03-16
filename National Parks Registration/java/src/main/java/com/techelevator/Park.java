package com.techelevator;

import java.time.LocalDate;

public class Park {
	private int parkId;
	private String parkName;
	private String parkLocation;
	private LocalDate parkEstablish;
	private int parkArea;
	private int parkAttendance;
	private String parkDescription;
	
	
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkLocation() {
		return parkLocation;
	}
	public void setParkLocation(String parkLocation) {
		this.parkLocation = parkLocation;
	}
	public LocalDate getParkEstablish() {
		return parkEstablish;
	}
	public void setParkEstablish(LocalDate parkEstablish) {
		this.parkEstablish = parkEstablish;
	}
	public int getParkArea() {
		return parkArea;
	}
	public void setParkArea(int parkArea) {
		this.parkArea = parkArea;
	}
	public int getParkAttendance() {
		return parkAttendance;
	}
	public void setParkAttendance(int parkAttendance) {
		this.parkAttendance = parkAttendance;
	}
	public String getParkDescription() {
		return parkDescription;
	}
	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}
}
