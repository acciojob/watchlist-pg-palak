package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();
    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorDb = new HashMap<>();

    public String addMovie(Movie movie) {

        String key = movie.getName();
        movieDb.put(key, movie);

        return "New movie added successfully";
    }

    public String addDirector(Director director) {

        String key = director.getName();
        directorDb.put(key, director);

        return "New director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if (movieDirectorDb.containsKey(directorName)) {
            List<String> list = movieDirectorDb.get(directorName);
            list.add(movieName);
            movieDirectorDb.put(directorName, list);
        } else {
            List<String> list = new ArrayList<>();
            list.add(movieName);
            movieDirectorDb.put(directorName, list);
        }

        return "New director movie pair added successfully";

    }

    public Movie getMovieByName(String movieName) {

        return movieDb.get(movieName);
    }

    public Director getDirectorByName(String directorName) {

        return directorDb.get(directorName);
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();

        for (String str : movieDb.keySet()) {
            list.add(str);
        }

        return list;
    }

    public List<String> getMoviesByDirectorName(String directorName) {

        List<String> movieList = movieDirectorDb.get(directorName);

        return movieList;
    }

    public String deleteDirectorByName(String directorName) {

        List<String> movies = movieDirectorDb.get(directorName);
        for (String movie : movies) {
            movieDb.remove(movie);
        }
        movieDirectorDb.remove(directorName);
        directorDb.remove(directorName);

        return "Director remove successfully";
    }

    public String deleteAllDirectors() {

        for (String director : directorDb.keySet()) {

            List<String> movie = movieDirectorDb.get(director);
            for (String str : movie) {

                movieDb.remove(str);
            }

            movieDirectorDb.remove(director);
            directorDb.remove(director);
        }

        return "All directors remove successfully";
    }
}
