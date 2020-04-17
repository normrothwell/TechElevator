package com.techelevator.city;

import org.apache.commons.dbcp2.BasicDataSource;

public class DAOExample {

	public static void main(String[] args) {
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("Kansas");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);
		
		dao.save(smallville); // this will call and add smallville to our world database
		
		City theCity = dao.findCityById(smallville.getId());
		
		System.out.println(theCity.getName() + " " + theCity.getId());

	}

}
