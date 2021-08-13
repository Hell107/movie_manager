package com.test.godel.movie_manager.domain.dao;

import com.test.godel.movie_manager.domain.dto.FilmDto;

import java.time.LocalDate;
import java.util.List;

//data access obj film

public interface FilmDao {
    List<FilmDto> listAll();
    List<FilmDto> getFilmsByDirector_LastName(String lastName);
    List<FilmDto> getFilmsByDirectorLastNameAndFromDate(String lastName, LocalDate date);
    List<FilmDto> getFilmsByDirectorLastNameAndUntilDate(String lastName, LocalDate date);
    List<FilmDto> getFilmsByDirectorLastNameAndUntilDateAndFromDate(String lastName, LocalDate releaseFromDate, LocalDate releaseUntilDate);


    List<FilmDto> getFilmsReleaseFromUntilDate(LocalDate releaseFromDate, LocalDate releaseUntilDate);

    List<FilmDto> getFilmsReleaseFromDate(LocalDate releaseUntilDate);
    List<FilmDto> getFilmsReleaseUntilDate(LocalDate releaseUntilDate);


}

