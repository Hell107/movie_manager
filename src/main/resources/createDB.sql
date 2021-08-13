create schema movies;

create table director
(
    id SERIAL,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    birth_date date not null,
    constraint director_pk
        primary key (id)
);

create table film
(
    id SERIAL,
    director_id INTEGER not null,
    film_name varchar(64) not null,
    release_date date not null,
    genre varchar(15) not null,
    constraint film_pk
        primary key (id),
    constraint film_director_id_fk
        foreign key (director_id) references director (id)
);
