package com.test.godel.movie_manager.domain.dao;


import com.test.godel.movie_manager.config.MovieManagerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@ContextConfiguration(classes = MovieManagerConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DefaultMovieManagerFilmDaoTest {
    @Autowired
    FilmDao filmDao;

    @Test
    void getFilmsByDirectorLastName() {
        assertEquals(0, filmDao.getFilmsByDirector_LastName("Scoresese").size());
        assertEquals(1, filmDao.getFilmsByDirector_LastName("Spilberg").size());
        assertEquals(3, filmDao.getFilmsByDirector_LastName("Tarcovsky").size());
        assertEquals(4, filmDao.getFilmsByDirector_LastName("Cameron").size());

    }
    @Test
    void getFilmsReleaseUntilDate() {
        assertEquals(4,filmDao.getFilmsReleaseUntilDate((LocalDate.parse("01011983", DateTimeFormatter.ofPattern("ddMMyyyy")))).size());
        assertEquals(7,filmDao.getFilmsReleaseUntilDate((LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy")))).size());
    }

    @Test
    void getFilmsReleaseFromDate() {
        assertEquals(10,filmDao.getFilmsReleaseFromDate(LocalDate.parse("01011970", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(7,filmDao.getFilmsReleaseFromDate(LocalDate.parse("01011980", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(0,filmDao.getFilmsReleaseFromDate(LocalDate.parse("01012020", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }

    @Test
    void getFilmsReleaseFromAndUntilDate() {
        assertEquals(7,filmDao.getFilmsReleaseFromUntilDate(LocalDate.parse("01011970", DateTimeFormatter.ofPattern("ddMMyyyy")), (LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy")))).size());
        assertEquals(2,filmDao.getFilmsReleaseFromUntilDate(LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy")), (LocalDate.parse("01012010", DateTimeFormatter.ofPattern("ddMMyyyy")))).size());
        assertEquals(1,filmDao.getFilmsReleaseFromUntilDate(LocalDate.parse("01011980", DateTimeFormatter.ofPattern("ddMMyyyy")), (LocalDate.parse("01011990", DateTimeFormatter.ofPattern("ddMMyyyy")))).size());
    }

    @Test
    void getFilmsByDirectorLastNameAndReleaseFromDate() {
        assertEquals(1, filmDao.getFilmsByDirectorLastNameAndFromDate("Cameron",LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(2, filmDao.getFilmsByDirectorLastNameAndFromDate("Fincher",LocalDate.parse("01011998", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }

    @Test
    void getFilmsByDirectorLastNameAndReleaseUntilDate() {
        assertEquals(1, filmDao.getFilmsByDirectorLastNameAndUntilDate("Fincher",LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(2, filmDao.getFilmsByDirectorLastNameAndUntilDate("Tarcovsky", LocalDate.parse("01011975", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }

    @Test
    void getFilmsByDirectorLastNameAndReleaseFromUntilDate() {
        assertEquals(0, filmDao.getFilmsByDirectorLastNameAndUntilDateAndFromDate("Spilberg",LocalDate.parse("01011999", DateTimeFormatter.ofPattern("ddMMyyyy")), LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
        assertEquals(3, filmDao.getFilmsByDirectorLastNameAndUntilDateAndFromDate("Tarcovsky",LocalDate.parse("01011960", DateTimeFormatter.ofPattern("ddMMyyyy")), LocalDate.parse("01012000", DateTimeFormatter.ofPattern("ddMMyyyy"))).size());
    }
}
