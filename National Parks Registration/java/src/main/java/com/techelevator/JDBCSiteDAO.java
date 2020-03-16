package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCSiteDAO implements SiteDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List <Site> getAvailableReservations(List<Integer>sites, double fee) {
		List <Site> allSites = new ArrayList<>();
		
		for (int x = 0; x<sites.size();x++) {
			String sqlGetSites = "SELECT * FROM site WHERE site_id = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSites, sites.get(x));
			while (results.next()) {
				allSites.add(mapRowToSites(results, fee));
			}
		}
		return allSites;
	}

	private Site mapRowToSites(SqlRowSet results, double fee) {
		
		Site theSite = new Site();
		theSite.setSiteId(results.getInt("site_id"));
		theSite.setCampgroundId(results.getInt("campground_id"));
		theSite.setSiteNumber(results.getInt("site_number"));
		theSite.setMaxOccupancy(results.getInt("max_occupancy"));
		theSite.setAccessible(results.getBoolean("accessible"));
		theSite.setMaxRvLength(results.getInt("max_rv_length"));
		theSite.setUtilities(results.getBoolean("utilities"));
		theSite.setCampgroundFee(fee);
		return theSite;
	}

	public void printSiteInformation(Site theSite, double bookingFee) {
	
		int siteId = (theSite.getSiteId());
		int maxOcc = (theSite.getMaxOccupancy());
		boolean access = (theSite.isAccessible());
		char accessible = 'N';
		if(!access) {		
			accessible = 'N';
		} else if(access) {
			accessible = 'Y';
		}
		int rvLength = (theSite.getMaxRvLength());
		
		boolean util = (theSite.isUtilities());
		String utilities = "";
		if (!util) {
			utilities = "N/A";
		} else if (util) {
			utilities = "Yes";		
		}
		
		String bookingCost = "$"+ bookingFee + "0";
		System.out.printf("%-13d %-15d %-14s %-12d %-9s %-9s\n",siteId, maxOcc, accessible, rvLength, utilities, bookingCost);
	
	}	
}


