package controller;

import model.Movies;
import repository.MovieRepositoryImpl;

import java.util.List;

public class MovieController {

    private MovieRepositoryImpl movieRepository;

    public MovieController(MovieRepositoryImpl movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void createMovieController(Movies movie) {
        movieRepository.createMovie(movie);
    }

    public List<Movies> findAllController() {
        return movieRepository.findAll();
    }
}