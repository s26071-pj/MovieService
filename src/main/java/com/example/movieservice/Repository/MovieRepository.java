package com.example.movieservice.Repository;

import com.example.movieservice.Model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();

    public MovieRepository(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void save(Movie movie){
        movieList.add(movie);
    }

    public List<Movie> getAll(){
        return this.movieList;
    }

    public Optional<Movie> findById(long id) {
        return movieList.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }

    public void remove(Movie deletingMovie) {
    }
}
