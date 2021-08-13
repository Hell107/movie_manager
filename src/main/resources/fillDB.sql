
--director with 4 films
INSERT INTO director (id, first_name, last_name, birth_date)
VALUES (1, 'James', 'Cameron', '1954-08-16"');

--director with 1 films
INSERT INTO director (id, first_name, last_name, birth_date)
VALUES (2, 'Steven', 'Spilberg', '1946-12-18');

--director with 0 films
INSERT INTO director (id, first_name, last_name, birth_date)
VALUES (3, 'Martin', 'Scoresese', '1942-11-17');

--director with 2 films
INSERT INTO director (id, first_name, last_name, birth_date)
VALUES (4, 'David', 'Fincher', '1962-08-28');

--director with 3 films
INSERT INTO director (id, first_name, last_name, birth_date)
VALUES (5, 'Andrey', 'Tarcovsky', '1932-04-04');

--films
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (1, 'Avatar', '2010-12-05', 'ACTION');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (1, 'Terminator', '1982-12-28', 'ACTION');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (1, 'Titanic', '1995-01-19', 'ROMANTIC');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (1, 'Schindler List', '1993-12-01', 'THRILLER');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (2, 'Terminal', '2004-05-18', 'COMEDY');

INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (4, 'TheGame', '2002-01-08', 'ACTION');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (4, 'Fight Club', '1999-12-11', 'THRILLER');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (5, 'Stalker', '1979-11-27', 'THRILLER');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (5, 'Solaris', '1972-08-19', 'THRILLER');
INSERT INTO film (director_id, film_name, release_date, genre)
VALUES (5, 'Mirror', '1974-05-15', 'THRILLER');
