package com.example.movieservice.Controller;

import com.example.movieservice.Model.Movie;
import com.example.movieservice.Servis.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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
    @Operation(summary = "Find all movies by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public ResponseEntity<List<Movie>> showAllMovies() {
//        return (ResponseEntity<List<Movie>>) this.movieService.getAllMovies();
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    //finding movies by id

    @GetMapping("/movies/{id}")
    @Operation(summary = "Get movie by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    //edp adding new movie

    @PostMapping("/movies")
    @Operation(summary = "Add new movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
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
    @Operation(summary = "Update movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
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
    @Operation(summary = "Delete a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
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
    @Operation(summary = "Checking if movie status is available")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Unknown Exception",
                    content = @Content)})
    public ResponseEntity<Void> updateFilmIsAvailable(@PathVariable Long id){
        movieService.changeAvailable(id);
        return ResponseEntity.ok().build();
    }
}
