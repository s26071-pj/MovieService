package com.example.movieservice.Controller;

import com.example.movieservice.Model.Movie;
import com.example.movieservice.Servis.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //adding and finding movies
//    @PostMapping("/AddingNewMovie")
//    public void addNewMovie(@RequestBody Movie movie){
//        movieService.save(movie);
//    }

    @GetMapping("/FindAllMovies")
    public ResponseEntity<List<Movie>> showAllMovies() {
//        return (ResponseEntity<List<Movie>>) this.movieService.getAllMovies();
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    //finding movies by id

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    //edp adding new movie

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie != null) {
            movieService.addMovie(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //updating movie

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        if (getMovieById(id) != null) {
            movie.setId(id);
            movieService.updateMovie(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    //Deleting movie

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deletingMovie(@PathVariable long id) {
        if (getMovieById(id) != null) {
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Is Avaiable
    @PutMapping("/isAvaiable/{id}")
    public ResponseEntity<Void> updateFilmIsAvailable(@PathVariable Long id){
        movieService.changeAvaiable(id);
        return ResponseEntity.ok().build();
    }
}
