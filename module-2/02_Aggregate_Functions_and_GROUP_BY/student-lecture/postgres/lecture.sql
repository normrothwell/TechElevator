-- ORDERING RESULTS

-- Populations of all countries in descending order

SELECT name, population FROM country ORDER BY population DESC;

--Names of countries and continents in ascending order

SELECT name, continent FROM country ORDER by continent ASC, name ASC;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.

SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy is not null ORDER BY lifeexpectancy DESC LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

SELECT (name || ', ' || district) AS "Name and State" FROM city WHERE district = 'California' OR district = 'Oregon' OR district = 'Washington' ORDER BY name ASC;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World

SELECT cast(AVG(lifeexpectancy) as numeric (10,2)) FROM country;

-- Total population in Ohio

SELECT SUM(population) AS "Total Population" FROM city WHERE district = 'Michigan';

-- The surface area of the smallest country in the world

SELECT MIN(surfacearea) AS "Surface Area" FROM country WHERE surfacearea is not null;
SELECT name, surfacearea FROM country ORDER BY surfacearea ASC limit 1;

-- The 10 largest countries in the world

SELECT * FROM country ORDER BY surfacearea DESC limit 10;

-- The number of countries who declared independence in 1991

SELECT count(*) AS "Number of Countries" FROM country WHERE indepyear = 1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least

SELECT language, COUNT(countrycode) AS "Countries" FROM countrylanguage GROUP BY language ORDER BY "Countries" DESC;

-- Average life expectancy of each continent ordered from highest to lowest

SELECT continent, AVG(lifeexpectancy) AS "Average Life Expectancy" FROM country GROUP BY continent ORDER BY "Average Life Expectancy" DESC;

-- Exclude Antarctica from consideration for average life expectancy

SELECT continent, AVG(lifeexpectancy) AS "Average Life Expectancy" FROM country WHERE continent <> 'Antarctica' GROUP BY continent ORDER BY "Average Life Expectancy" DESC;

-- Sum of the population of cities in each state in the USA ordered by state name

SELECT district, SUM(population) FROM city WHERE countrycode = 'USA' GROUP BY district ORDER BY district ASC;

-- The average population of cities in each state in the USA ordered by state name

SELECT district, cast (AVG(population) as NUMERIC (10,2)) AS "Average Population" FROM city WHERE countrycode = 'USA' GROUP BY district ORDER BY district;

-- SUBQUERIES
-- Find the names of cities under a given government leader

SELECT name, district FROM city WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II');

SELECT city.name, city.district, country.headofstate FROM city, country WHERE countrycode IN (SELECT code FROM country WHERE headofstate = 'Elisabeth II');

-- Find the names of cities whose country they belong to has not declared independence yet

SELECT code FROM country WHERE indepyear is null;

SELECT c.name, c.district, c.countrycode, cc.name FROM city AS c, country AS cc WHERE c.countrycode IN (SELECT code FROM country WHERE indepyear is null);

-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

SELECT c.name, co.name FROM city AS c, country AS co WHERE co.code = 'USA' AND c.countrycode = 'USA';

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

SELECT name, population FROM city ORDER BY population DESC LIMIT 20 OFFSET 10;

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

SELECT (name || ' is in the state of ' || district) as city_name FROM city WHERE countrycode = 'USA';

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

SELECT count(*) as city_count FROM city;

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

SELECT SUM(population) AS "Total Population", cast(AVG(population) as numeric (10,2)) as "Average City Population", COUNT(*) as "Number of Cities" from city;

-- Gets the MIN population and the MAX population from the city table.

SELECT MIN(population) as "Min population", MAX(population) as "Max Population" FROM city;

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.

SELECT countrycode, MIN(population) as "Minimum Population", MAX(population) as "Maximum population" FROM city GROUP BY countrycode ORDER BY "Minimum Population";