package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;

	// Before run any tests, this method will initialize the datasource for testing
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername ("postgres");
		dataSource.setPassword("postgres1");
		
		//We can disable the autocommit for the connections so we can rollback after 
		// each test
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea" +
		                          ", indepyear, population, lifeexpectancy, gnp, gnpold, localname," +
				                  " governmentform, headofstate, capital, code2) " +
				 "VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919," +
				                  " 22720000, 45.9000015, 5976.00, " + 
		               "NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		
	
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		dao = new JDBCCityDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void save_new_city_and_read_it_back() {
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		
		// this is the dao method we are testing - the SAVE (Create)
		dao.save(theCity);
		City savedCity = dao.findCityById(theCity.getId()); // this SHOULD return the city object we just
		                                              	    // added to the database
		
		assertNotEquals(null, theCity.getId());
		// asserts to make sure each attribute is the same for the cities to be equal
		assertEquals(theCity.getId(), savedCity.getId());
		assertEquals(theCity.getName(), savedCity.getName());
		assertEquals(theCity.getDistrict(), savedCity.getDistrict());
		assertEquals(theCity.getCountryCode(), savedCity.getCountryCode());
		assertEquals(theCity.getPopulation(), savedCity.getPopulation());
	}
	
	@Test
	public void returns_cities_by_country_code() {
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		
		dao.save(theCity);
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		// asserts to make sure each attribute is the same for the cities to be equal
		assertEquals(theCity.getId(), savedCity.getId());
		assertEquals(theCity.getName(), savedCity.getName());
		assertEquals(theCity.getDistrict(), savedCity.getDistrict());
		assertEquals(theCity.getCountryCode(), savedCity.getCountryCode());
		assertEquals(theCity.getPopulation(), savedCity.getPopulation());
		
	}
	
	@Test
	public void returns_multiple_cities_by_country_code() {
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 15622));
		
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		assertNotNull(results);
		assertEquals(2, results.size());
	}
	
	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);
		
		List<City> results = dao.findCityByDistrict(testDistrict);
		
		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEquals(theCity, savedCity);
		
	}
	
	private void assertCitiesAreEquals(City theCity, City savedCity) {
		// asserts to make sure each attribute is the same for the cities to be equal
				assertEquals(theCity.getId(), savedCity.getId());
				assertEquals(theCity.getName(), savedCity.getName());
				assertEquals(theCity.getDistrict(), savedCity.getDistrict());
				assertEquals(theCity.getCountryCode(), savedCity.getCountryCode());
				assertEquals(theCity.getPopulation(), savedCity.getPopulation());
	}
	
	// helper method to create a city object for us -- we will reuse this!
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(TEST_COUNTRY);
		theCity.setPopulation(population);
		
		return theCity;
	}
}








