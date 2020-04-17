-- INSERT

-- 1. Add Klingon as a spoken language in the USA
-- 2. Add Klingon as a spoken language in Great Britain

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'Klingon', false, 10.0);

SELECT * FROM countrylanguage WHERE countrycode = 'GBR';

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('GBR', 'Klingon', false, 9.8);

-- UPDATE

-- 1. Update the capital of the USA to Houston

SELECT * FROM city where name = 'Houston';

UPDATE country SET capital = 3796 WHERE code = 'USA';

SELECT city.name FROM city JOIN country ON country.code = city.countrycode WHERE country.capital = 3796 AND city.id = 3796;

-- 2. Update the capital of the USA to Washington DC and the head of state

SELECT * FROM city WHERE name = 'Washington';

UPDATE country SET capital = city.id FROM city WHERE city.name = 'Washington' AND city.countrycode = 'USA';

SELECT * FROM country where code = 'USA';

-- DELETE

-- 1. Delete English as a spoken language in the USA
-- 2. Delete all occurrences of the Klingon language 

DELETE FROM countrylanguage WHERE language = 'English' and countrycode = 'USA';

DELETE FROM countrylanguage WHERE language = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.



-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?



-- 3. Try deleting the country USA. What happens?



-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', true, 86.2);

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

BEGIN TRANSACTION

DELETE FROM countrylanguage;
ROLLBACK;

-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.