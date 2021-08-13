package com.test.godel.movie_manager.controller;

import com.test.godel.movie_manager.domain.dao.FilmDao;
import com.test.godel.movie_manager.domain.dto.FilmDto;
import com.test.godel.movie_manager.req.DefaultRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class MovieController {
    FilmDao filmDao;

    public MovieController(FilmDao filmDao) {
        this.filmDao = filmDao;
    }
    static List<FilmDto> filmDtoList;
    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(DefaultRequest req) {

        if (req.getReleaseFromDate() != null && req.getDirectorLastName() != null) {
            filmDtoList = filmDao.getFilmsByDirectorLastNameAndFromDate(req.getDirectorLastName(), req.getReleaseFromDate());
        } else if (req.getReleaseUntilDate() != null && req.getDirectorLastName() != null) {
            filmDtoList = filmDao.getFilmsByDirectorLastNameAndUntilDate(req.getDirectorLastName(), req.getReleaseUntilDate());
        } else if (req.getDirectorLastName() != null) {
            filmDtoList = filmDao.getFilmsByDirector_LastName(req.getDirectorLastName());
        } else if (req.getReleaseFromDate() != null && req.getReleaseUntilDate() != null) {
            filmDtoList = filmDao.getFilmsReleaseFromUntilDate(req.getReleaseFromDate(), req.getReleaseUntilDate());
        } else if (req.getReleaseFromDate() != null) {
            filmDtoList = filmDao.getFilmsReleaseUntilDate(req.getReleaseFromDate());
        } else if (req.getReleaseUntilDate() != null) {
            filmDtoList = filmDao.getFilmsReleaseFromDate(req.getReleaseUntilDate());
        }else if (req.getDirectorLastName() != null && req.getReleaseFromDate() != null && req.getReleaseUntilDate() != null) {
            filmDtoList = filmDao.getFilmsByDirectorLastNameAndUntilDateAndFromDate(req.getDirectorLastName(), req.getReleaseFromDate(), req.getReleaseUntilDate());
        }
        else {
            filmDtoList = new ArrayList<>();
        }
        return filmDtoList.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(filmDtoList, HttpStatus.OK);
    }

}


