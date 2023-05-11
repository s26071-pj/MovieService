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
    @PostMapping("/AddingNewMovie")
    public void addNewMovie(@RequestBody Movie movie){
        movieService.save(movie);
    }

    @GetMapping("/FindAllMovies")
    public ResponseEntity<List<Movie>> showAllMovies(){
//        return (ResponseEntity<List<Movie>>) this.movieService.getAllMovies();
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    //finding movies by id

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@RequestParam("id") long id){
        return ResponseEntity.ok(movieService.findMovieById(id));
    }
}
