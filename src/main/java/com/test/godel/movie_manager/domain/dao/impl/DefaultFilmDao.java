package com.test.godel.movie_manager.domain.dao.impl;

import com.test.godel.movie_manager.domain.dao.FilmDao;
import com.test.godel.movie_manager.domain.dao.convert.FilmConverter;
import com.test.godel.movie_manager.domain.dao.entity.Film;
import com.test.godel.movie_manager.repos.FilmRepo;
import com.test.godel.movie_manager.domain.dto.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultFilmDao implements FilmDao {

    @Autowired
    private final FilmRepo filmRepository;

    public DefaultFilmDao(FilmRepo filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<FilmDto> listAll() {
        List<Film> films = filmRepository.findAll();
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsReleaseFromUntilDate(LocalDate releaseFromDate, LocalDate releaseUntilDate) {
        List<Film> films = filmRepository.getFilmsByReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(releaseFromDate, releaseUntilDate);
        return  getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsReleaseFromDate(LocalDate releaseFromDate) {
        List<Film> films = filmRepository.getFilmsByReleaseDateGreaterThanEqual(releaseFromDate);
        return  getDtoList(films);
    }


    @Override
    public List<FilmDto> getFilmsByDirector_LastName(String lastName) {
        List<Film> films = filmRepository.getFilmsByDirector_LastName(lastName);
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsReleaseUntilDate(LocalDate date) {
        List<Film> films = filmRepository.getFilmsByReleaseDateLessThanEqual(date);
        return getDtoList(films);
    }


    @Override
    public List<FilmDto> getFilmsByDirectorLastNameAndFromDate(String lastName, LocalDate date) {
        List<Film> films = filmRepository.getFilmsByDirector_LastNameAndReleaseDateGreaterThanEqual(lastName, date);
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsByDirectorLastNameAndUntilDate(String lastName, LocalDate date) {
        List<Film> films = filmRepository.getFilmsByDirector_LastNameAndReleaseDateLessThanEqual(lastName, date);
        return getDtoList(films);
    }

    @Override
    public List<FilmDto> getFilmsByDirectorLastNameAndUntilDateAndFromDate(String lastName, LocalDate releaseFromDate, LocalDate releaseUntilDate) {
        List<Film> films = filmRepository.getFilmsByDirector_LastNameAndReleaseDateGreaterThanEqualAndReleaseDateLessThanEqual(lastName, releaseFromDate, releaseUntilDate);
        return getDtoList(films);
    }

    private List<FilmDto> getDtoList(List<Film> films) {
        List<FilmDto> filmDtoList = new ArrayList<>();
        if (films.size() > 0) {
            films.forEach(film -> filmDtoList.add(FilmConverter.toDto(film)));
        }
        return filmDtoList;
    }
}
