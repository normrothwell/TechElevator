package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {

	private JdbcTemplate jdbcTemplate;
	
	// This is a constructor where we connect the datasource (db information) to the jdbcTemplate object (Spring)
	public JDBCCityDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void save(City newCity) {
		// insert into the database, so names must match the database names
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
		  "VALUES(?, ?, ?, ?,?)";  // let postgres get the next id number available (autogenerate the number)- CHANGE!
		newCity.setId(getNextCityId());  
		
		jdbcTemplate.update(sqlInsertCity, 
				newCity.getId(),	// 
				newCity.getName(),
				newCity.getCountryCode(),
				newCity.getDistrict(),
				newCity.getPopulation());  
		// These are gets because we need to take the java object and save it to the db, we we need to 
		// get the values from Java to go to postgres
	}
	
	private int getNextCityId() {
		 							// returns from the database the next city_id value		
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet(" SELECT nextval('seq_city_id')");
		if (nextIdResult.next()) {  // only expecting one value back, so this is an IF statement
			return nextIdResult.getInt(1); // get what comes back in the first position and turn it into a integer
		} else {
			throw new RuntimeException("Uhoh!  Something went wrong while getting the next id!");
		}
	}

	@Override
	public City findCityById(int id) {
		// take the id and pass it to postgres who will return a city object
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " +
		     "FROM city WHERE id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if (results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
		
	}
	
	// it takes each individual result and puts it into a Java city object, which it returns
	private City mapRowToCity(SqlRowSet results) {
		City theCity = new City();
		theCity.setId(results.getInt("id"));  //inside the parens is the db column name and mapping to the City object
		                                      //  attribute name
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}

	@Override
	public List<City> findCitiesByCountryCode(String countryCode) {
		String sqlFindCitiesByCountryCode = "SELECT * FROM city WHERE countrycode = ?";
		List<City> cityList = new ArrayList<>(); // a list of city objects
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCitiesByCountryCode, countryCode);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cityList.add(theCity);
		}
		return cityList;
	}

	@Override
	public List<City> findCitiesByDistrict(String district) {
		String sqlFindCitiesByDistrict = "SELECT * FROM city " +
	     " WHERE district = ?";
		List<City> cityList = new ArrayList<>();
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCitiesByDistrict, district);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cityList.add(theCity);
		}
		
		return cityList;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(City city) {
		String sqlDeleteCity = "DELETE FROM city WHERE name = ? " +
	      "AND population = ?";
		jdbcTemplate.update(sqlDeleteCity, city.getName(), city.getPopulation());

	}
	

	

}
