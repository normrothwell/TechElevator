package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public JDBCCityDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public City findCityById(int id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population FROM city WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if (results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	private City mapRowToCity(SqlRowSet results) {
		City theCity = new City();
		theCity.setId(results.getInt("id"));
		theCity.setName(results.getString("name"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}

	@Override
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(), newCity.getDistrict(), newCity.getPopulation());

	}

	private int getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet(" SELECT nextval('seq_city_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getInt(1);
		}else {
			throw new RuntimeException("Something is wrong");
		}
	}

	@Override
	public List<City> findCitiesByCountryCode(String countrycode) {
		String sqlFindCitiesByCountryCode = "SELECT * FROM city WHERE countrycode = ?";
		List<City> cityList = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCitiesByCountryCode, countrycode);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cityList.add(theCity);
		}
		return cityList;
	}

	@Override
	public List<City> findCitiesByDistrict(String district) {
		String sqlFindCitiesByDistrict = "SELECT * FROM city WHERE district = ?";
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
		String sqlDeleteCity = "DELETE FROM city WHERE name = ?";
		jdbcTemplate.update(sqlDeleteCity, city.getName());

	}
	
	public List<Project> getAllActiveProjects(){
		List<Project> projectList = new ArrayList<>();
		String sqlGetAllActiveProjects = "SELECT * FROM project WHERE (now() BETWEEN from_date and to_date) OR (now() > from_date AND to_date IS NULL)";
		SqlRowSet results = jdbcTemplate(sqlGetAllActiveProjects);
		while (results.next()) {
			Project project = mapRowToActiveProject(results);
			
		}
		
		return projectList;
	}
	
	private Project mapRowToActiveProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getLong("project_id"));
		if (results.getDate("from_date") != null){
			project.setStartDate(results.getDate("from_date").toLocalDate());
		}
	}

}
