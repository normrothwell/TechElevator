-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

INSERT INTO actor (first_name, last_name) VALUES ('Hampton', 'Avenue');
INSERT INTO actor (first_name, last_name) VALUES ('Lisa', 'Byway');
UPDATE actor SET first_name = 'HAMPTON' WHERE first_name = 'Hampton';
UPDATE actor SET last_name = 'AVENUE' WHERE last_name = 'Avenue';
UPDATE actor SET first_name = 'LISA' WHERE first_name = 'Lisa';
UPDATE actor SET last_name = 'BYWAY' WHERE last_name = 'Byway';

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.

INSERT INTO film (title, description, release_year, language_id, length) VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in', 2008, (SELECT language_id FROM language WHERE name = 'English'), 198);


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

SELECT * from film WHERE title = 'EUCLIDEAN PI';
INSERT INTO film_actor (actor_id, film_id) VALUES ((SELECT actor_id FROM actor WHERE first_name = 'HAMPTON' AND last_name = 'AVENUE'), (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'));

-- 4. Add Mathmagical to the category table.

INSERT INTO category (name) VALUES ('Mathmagical');

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

INSERT INTO film_category (film_id, category_id) VALUES ((SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'), 17);
UPDATE film_category SET category_id = 17 WHERE film_id = (SELECT film_id FROM film WHERE title = 'EGG IGBY');
UPDATE film_category SET category_id = 17 WHERE film_id = (SELECT film_id FROM film WHERE title = 'KARATE MOON');
UPDATE film_category SET category_id = 17 WHERE film_id = (SELECT film_id FROM film WHERE title = 'RANDOM GO');
UPDATE film_category SET category_id = 17 WHERE film_id = (SELECT film_id FROM film WHERE title = 'YOUNG LANGUAGE');

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

SELECT film_id FROM film_category WHERE category_id = 17;
UPDATE film SET rating = 'G' WHERE film.film_id IN (SELECT film_category.film_id FROM film_category WHERE film_category.category_id = 17);


-- 7. Add a copy of "Euclidean PI" to all the stores.

INSERT INTO inventory (film_id, store_id) VALUES ((SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'), 1);
INSERT INTO inventory (film_id, store_id) VALUES ((SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI'), 2);

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE FROM film WHERE title = 'EUCLIDEAN PI';

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE FROM category WHERE name = 'Mathmagical';

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical');

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE FROM category WHERE name = 'Mathmagical';
DELETE FROM film WHERE title = 'EUCLIDEAN PI';

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

DELETE FROM film_actor WHERE film_id = (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI');
DELETE FROM inventory WHERE film_id = (SELECT film_id FROM film WHERE title = 'EUCLIDEAN PI');
DELETE FROM film WHERE title = 'EUCLIDEAN PI';
