package com.test.godel.movie_manager.domain.dao.convert;

import com.test.godel.movie_manager.domain.dao.entity.Film;
import com.test.godel.movie_manager.domain.dto.FilmDto;

public class FilmConverter {

    //convert film in data transfer object
    public static FilmDto toDto(Film film){
        FilmDto filmDto = new FilmDto();
        filmDto.setFirstName(film.getDirector().getFirstName());
        filmDto.setLastName(film.getDirector().getLastName());
        filmDto.setBirthDate(film.getDirector().getBirthDate());
        filmDto.setFilmName(film.getFilmName());
        filmDto.setReleaseDate(film.getReleaseDate());
        filmDto.setGenre(film.getGenre());
        return filmDto;
    }
}
