-- Display all the films and their language

SELECT film.title, language.name from film JOIN language ON film.language_id = language.language_id;

-- Display all the films and in English

SELECT film.title, language.name from film JOIN language ON film.language_id = language.language_id WHERE language.name = 'English';

-- Display all the films with their category

SELECT film.title, category.name FROM film JOIN film_category ON film.film_id = film_category.film_id JOIN category ON film_category.category_id = category.category_id;

-- Display all the films with a category of Horror

SELECT film.title, category.name FROM film JOIN film_category ON film.film_id = film_category.film_id JOIN category ON film_category.category_id = category.category_id WHERE category.name = 'Horror';

-- Display all the films with a category of Horror and title that begins with the letter F

SELECT film.title, category.name FROM film JOIN film_category ON film.film_id = film_category.film_id JOIN category ON film_category.category_id = category.category_id WHERE category.name = 'Horror' AND film.title LIKE 'F%';

-- Who acted in what together?

SELECT f.title, al.first_name || ' ' || al.last_name || ' ' || a2.first_name || ' ' || a2.last_name FROM film f JOIN film_actor fal ON f.film_id = fal.film_id JOIN film_actor fa2 ON f.film_id = fa2.film_id AND fal.actor_id <> fa2.actor_id JOIN actor al ON fal.actor_id = al.actor_id JOIN actor a2 ON fa2.actor_id = a2.actor_id;

-- How many times have two actors appeared together?

-- What movies did the two most often acted together actors appear in together?
