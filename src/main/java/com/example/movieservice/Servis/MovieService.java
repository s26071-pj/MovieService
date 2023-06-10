package com.example.movieservice.Servis;

import com.example.movieservice.Exception.MovieNotFoundException;
import com.example.movieservice.Model.Movie;
import com.example.movieservice.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

    public void changeAvailable(Long id){
        Movie target = findById(id);
        target.setAvailable(!target.getAvailable());
        movieRepository.save(target);
    }
}
