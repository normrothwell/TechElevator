ide-- Select every column from users where the user's role is manager
SELECT * FROM users WHERE role = 'manager';
-- Select name and created from posts where the post's body isn't null and the post was created in Aug. 2019
SELECT name, created FROM posts WHERE body IS NOT null AND created BETWEEN '2019-08-01' AND '2019-08-31';
-- Select first_name and email from users, ordered by created, latest first
SELECT first_name, email FROM users ORDER BY created DESC;
-- Select published date from posts and a count of all the posts published/not published
SELECT COUNT(published), created FROM posts GROUP BY created;
-- Select the user's first_name, last_name, and email and the name of the post for all posts created after Oct. 1st 2019
SELECT  users.email, users.first_name, users.last_name, posts.name FROM posts JOIN users ON posts.user_id = users.id WHERE posts.created >= '2019-10-01';
