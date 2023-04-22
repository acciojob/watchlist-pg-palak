package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.*;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String movieAdded =  movieService.addMovie(movie);

        return new ResponseEntity<>(movieAdded, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String directorAdded = movieService.addDirecto(director);

        return new ResponseEntity<>(directorAdded, HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public  ResponseEntity<String> addMovieDirectorPair(@RequestParam("director")String movie, @RequestParam("movie")String director){
        String movieDirectorPair = movieService.addMovieDirectorPair(movie, director);

        return new ResponseEntity<>(movieDirectorPair, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName")String movieName){

        Movie movie = movieService.getMovieByName(movieName);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director>  getDirectorByName(@PathVariable("name")String name){

        Director director = movieService.getDirectorByName(name);

        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String director){

        List<String> movie = movieService.getMoviesByDirectorName(director);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movieList = movieService.findAllMovies();

        return new ResponseEntity<>(movieList, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName){

        String removeDirector =  movieService.deleteDirectorByName(directorName);

        return new ResponseEntity<>(removeDirector, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        String allDirectorRemove = movieService.deleteAllDirectors();

        return new ResponseEntity<>(allDirectorRemove, HttpStatus.CREATED);
    }
}