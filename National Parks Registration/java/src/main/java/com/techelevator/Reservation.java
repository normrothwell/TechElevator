package com.techelevator;

import java.time.LocalDate;

public class Reservation {
	
	private int reserverationId;
	private int siteId;
	private String siteName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private LocalDate createDate;
	
	
	public int getReserverationId() {
		return reserverationId;
	}
	public void setReserverationId(int reserverationId) {
		this.reserverationId = reserverationId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
