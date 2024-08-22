package com.nikhil.bootstrap;

import com.nikhil.domain.Movie;
import com.nikhil.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll().thenMany(
                Flux.just("Jawan", "Gadar", "Pathaan", "Baahubali", "Animal", "KGF", "Dangal", "Sanju", "PK", "Tiger")
                        .map(Movie::new)
                        .flatMap(movieRepository::save)
        );
    }
}
