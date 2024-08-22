package com.nikhil.service;

import com.nikhil.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> findMovieById(String id);
    Flux<Movie> getAllMovies();
}
