package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        String movieAdded = movieRepository.addMovie(movie);
        return movieAdded;
    }

    public String addDirecto(Director director) {
        String directorAdded = movieRepository.addDirector(director);

        return directorAdded;
    }

    public String addMovieDirectorPair(String movie, String director) {
        String movieDirectorPair = movieRepository.addMovieDirectorPair(movie, director);
        return movieDirectorPair;
    }

    public Movie getMovieByName(String movieName) {

        Movie movie = movieRepository.getMovieByName(movieName);

        return movie;
    }

    public Director getDirectorByName(String directorName) {

        Director director = movieRepository.getDirectorByName(directorName);

        return director;
    }

    public List<String> findAllMovies() {
        List<String> list = movieRepository.findAllMovies();
        return list;
    }

    public List<String> getMoviesByDirectorName(String directorName) {

        List<String> movieList = movieRepository.getMoviesByDirectorName(directorName);

        return movieList;
    }

    public String deleteDirectorByName(String directorName) {

        String removeDirector = movieRepository.deleteDirectorByName(directorName);

        return removeDirector;
    }

    public String deleteAllDirectors() {
        String allDirectorRemove = movieRepository.deleteAllDirectors();
        return allDirectorRemove;
    }
}
