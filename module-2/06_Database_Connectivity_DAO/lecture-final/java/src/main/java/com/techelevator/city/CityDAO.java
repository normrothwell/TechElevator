package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public void save(City newCity); // create (or add to the database)
	public City findCityById(int id); // read (or SELECT from database)
	public List<City> findCitiesByCountryCode(String countryCode);
	public List<City> findCitiesByDistrict(String district);
	public void update(City city);
	public void delete(City city);
	
}
