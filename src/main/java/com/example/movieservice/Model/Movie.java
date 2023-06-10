package com.example.movieservice.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
@Schema(title="Movie", name="movie", description = "")
@Entity
public class Movie {

    @Schema(description = "Identity number of movie")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Movie name")
    private String name;
    @Schema(description = "Movie category")
    @Enumerated(EnumType.STRING)
    private MovieCategory category;

    @Schema(description = "Movie available status")
    private boolean Available;

    public Movie() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory category) {
        this.category = category;
    }

    public boolean getAvailable(){
        return false;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

}
