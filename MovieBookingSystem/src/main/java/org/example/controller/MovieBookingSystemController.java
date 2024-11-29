package org.example.controller;

import org.example.model.singeton.MovieBookingSystem;

public class MovieBookingSystemController {
    private MovieBookingSystem movieBookingSystem;


    public MovieBookingSystemController() {
        this.movieBookingSystem = MovieBookingSystem.getInstance();
    }
}
