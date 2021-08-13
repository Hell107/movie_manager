package com.test.godel.movie_manager.config;

import com.test.godel.movie_manager.domain.dao.FilmDao;
import com.test.godel.movie_manager.domain.dao.impl.DefaultFilmDao;
import com.test.godel.movie_manager.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "com.test.godel.movie_manager.repos")
@EntityScan(value = "com\\test\\godel\\movie_manager\\domain\\dao\\entity")
@PropertySource("classpath:/application.yml")
public class MovieManagerConfig {
    @Autowired
    private FilmRepo filmRepository;

    @Bean
    public FilmDao filmDao() {
        return new DefaultFilmDao(filmRepository);
    }
}
