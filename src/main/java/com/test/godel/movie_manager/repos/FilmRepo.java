package com.test.godel.movie_manager.repos;

import com.test.godel.movie_manager.domain.dao.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

//film content repository

public interface FilmRepo extends JpaRepository<Film, Long> {
    //methods for get film list by
    List<Film> getFilmsByDirector_LastName(String lastName);
    List<Film> getFilmsByDirector_LastNameAndReleaseDateGreaterThanEqual(String lastName, LocalDate date);
    List<Film> getFilmsByDirector_LastNameAndReleaseDateLessThanEqual(String lastName, LocalDate date);

    List<Film> getFilmsByDirector_LastNameAndReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(String lastName, LocalDate releaseFromDate, LocalDate releaseUntilDate);

    List<Film> getFilmsByReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(LocalDate releaseFromDate, LocalDate releaseUntilDate);

    List<Film> getFilmsByReleaseDateLessThanEqual(LocalDate releaseUntilDate);
    List<Film> getFilmsByReleaseDateGreaterThanEqual(LocalDate releaseFromDate);

}

