-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name, population FROM country
  ORDER BY population DESC;

--Names of countries and continents in ascending order
SELECT name, continent FROM country
  ORDER BY continent ASC, name ASC;
 
-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy
  FROM country
  WHERE lifeexpectancy IS NOT NULL
  ORDER BY lifeexpectancy DESC
  LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT (name || ', ' || district || ' ' || countrycode) as name_and_state
  FROM city
  WHERE district = 'California'
  OR district = 'Oregon'
  OR district = 'Washington'
  ORDER BY district, name;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy) FROM country; 

SELECT cast(AVG(lifeexpectancy) as numeric(15,2)) FROM country; 
--  Maybe this is less confusing

-- Total population in Ohio
SELECT SUM(population) as "Total population of Ohio" FROM city
WHERE population IS NOT NULL AND -- this is not needed because sum, max and min do not consider null entries
district = 'Ohio';

-- The surface area of the smallest country in the world
SELECT MIN(surfacearea) FROM country;
SELECT name, surfacearea FROM country ORDER BY surfacearea ASC LIMIT 1;

-- The 10 largest countries in the world
SELECT * FROM country ORDER BY surfacearea DESC limit 10;
-- The number of countries who declared independence in 1991

SELECT count(*) FROM country WHERE indepyear = 1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT language, COUNT(countrycode) AS countries
FROM countrylanguage
GROUP BY language
ORDER BY countries DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT continent, AVG(lifeexpectancy) as life_expectancy
FROM COUNTRY
GROUP BY continent
ORDER BY life_expectancy DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT continent, AVG(lifeexpectancy) as life_expectancy
FROM COUNTRY
WHERE lifeexpectancy IS NOT NULL -- or I could say WHERE continent <> 'Antarctica'
GROUP BY continent
ORDER BY life_expectancy DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT district, SUM(population)
  FROM city
  WHERE countrycode = 'USA'
  GROUP BY district
  ORDER BY district;

-- The average population of cities in each state in the USA ordered by state name
SELECT district, cast(AVG(population) as numeric(10,2))
  FROM city
  WHERE countrycode = 'USA'
  GROUP BY district
  ORDER BY district;

-- SUBQUERIES
-- Find the names of cities under a given government leader
SELECT name, code FROM country WHERE headofstate = 'Elisabeth II';


SELECT name, district FROM city WHERE countrycode IN
 (SELECT code FROM country WHERE headofstate = 'Elisabeth II'); -- subquery
 

-- Find the names of cities whose country they belong to has not declared independence yet
SELECT code FROM country WHERE indepyear IS NULL;

-- ci is an alias for the city table
-- co is an alias for the country table

SELECT ci.name, ci.district, ci.countrycode, co.headofstate FROM city as ci, country as co
 WHERE co.code IN
(SELECT code FROM country WHERE indepyear IS NULL);


-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "ci" for city and "co" for country.
SELECT ci.name, co.name FROM city as ci, country as co
WHERE co.code = 'USA' AND ci.countrycode = 'USA';

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

SELECT name, population
FROM city
 --ORDER BY population DESC
LIMIT 10  OFFSET 10;
-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.
SELECT ( name || ' is in the state of ' || district)
AS city_name  FROM city WHERE countrycode = 'USA';

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. 
-- Only returns a single row of value(s) unless used with GROUP BY.


-- Counts the number of rows in the city table
SELECT count(*) as city_count FROM city;
-- Also counts the number of rows in the city table
SELECT count(name) as city_count FROM city;
SELECT count(population) as city_count FROM city;

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.
SELECT SUM(population) as total_city_population, 
cast(AVG(population) as numeric(10,2)) as avg_city_population,
COUNT(*) as number_of_cities 
FROM city;

-- Gets the MIN population and the MAX population from the city table.
SELECT MIN(population) as minimum_population,
MAX(population) as maximum_population 
FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. 
-- For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
SELECT countrycode, MIN(population) as smallest_population,
MAX(population) as largest_population
FROM city
GROUP BY countrycode
ORDER BY countrycode;


SELECT country.continent, MAX(city.population) FROM country JOIN city ON country.code = city.countrycode GROUP BY country.continent;

SELECT city.name, countrylanguage.language FROM city JOIN country ON country.code = city.countrycode JOIN countrylanguage ON countrylanguage.countrycode = country.code WHERE countrylanguage.isofficial = true AND country.continent = 'South America'  AND city.population > 1000000









