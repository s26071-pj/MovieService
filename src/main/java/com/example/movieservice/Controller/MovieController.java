package com.example.movieservice.Controller;

import com.example.movieservice.Model.Movie;
import com.example.movieservice.Servis.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/AddingNewMovie")
    public void addNewMovie(@RequestBody Movie movie){
        movieService.save(movie);
    }

    @GetMapping("/FindAllMovies")
    public List<Movie> showAllMovies(){
        return this.movieService.getAllMovies();
    }
}
