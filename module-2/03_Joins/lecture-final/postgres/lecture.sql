-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT * FROM payment WHERE payment_id = 16666;

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT * FROM payment
 JOIN customer ON payment.customer_id = customer.customer_id
  WHERE payment_id = 16666;

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT payment.*, customer.first_name, customer.last_name
 FROM payment
 JOIN customer ON payment.customer_id = customer.customer_id
 WHERE payment_id = 16666;

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.
SELECT payment.*, customer.first_name, customer.last_name, rental.return_date
 FROM payment
 JOIN customer ON payment.customer_id = customer.customer_id
 JOIN rental ON payment.rental_id = rental.rental_id
 WHERE payment_id = 16666;

-- What did they rent? Film id can be gotten through inventory.
SELECT payment.*, customer.first_name, customer.last_name, rental.return_date, film.title
 FROM payment
 JOIN customer ON payment.customer_id = customer.customer_id
 JOIN rental ON payment.rental_id = rental.rental_id
 JOIN inventory ON rental.inventory_id = inventory.inventory_id
 JOIN film ON inventory.film_id = film.film_id
 WHERE payment_id = 16666;

-- What if we wanted to know who acted in that film?
SELECT film.title, actor.first_name, actor.last_name
FROM film
JOIN film_actor ON film_actor.film_id = film.film_id
JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE film.title = 'VOICE PEACH';

-- What if we wanted a list of all the films and their categories ordered by film title
-- alias can be used to make the typing easier *** film f says the we can use f in place of typing film
SELECT f.title, c.name
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
ORDER BY f.title;

-- Show all the 'Comedy' films ordered by film title
SELECT f.title, c.name
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
ORDER BY f.title;

-- Finally, let's count the number of films under each category
SELECT c.name, COUNT(c.name)
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
GROUP BY c.name
ORDER BY c.name;

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)


-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.

-- Let's display a list of all countries and their capitals, if they have some.
SELECT co.name as "Country name", ci.name as "Capital"
FROM country co -- this is where I am saying that co stands for the country table
JOIN city ci ON co.capital = ci.id; -- this is where I am saying that ci stands for the city table

-- Only 232 rows
-- But we’re missing entries:
SELECT count(*) FROM country;

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:
SELECT co.name as "Country name", ci.name as "Capital"
FROM country co 
LEFT JOIN city ci ON co.capital = ci.id; -- give me the ones that DON'T HAVE A CAPITAL AS WELL

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates
SELECT first_name FROM actor
UNION
SELECT first_name FROM customer
ORDER BY first_name;

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer
SELECT first_name, 'A' AS source
  FROM actor
UNION
SELECT first_name, 'C' AS source
  FROM customer
ORDER BY first_name;