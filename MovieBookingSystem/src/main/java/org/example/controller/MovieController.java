package org.example.controller;

import org.example.model.Client;
import org.example.model.Movie;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController extends Controller {
    private Map<Integer, Client> movies;

    public MovieController(Connection connection) {
        super(connection);
        this.movies = new HashMap<>();
    }
    //WORKING

    // Method to insert a movie into the database
    public void addMovie(String title, String genre, double rating, int duration, String synopsis) {
        Movie movie = new Movie(title, duration, rating, genre, synopsis);
        movie.insertMovie();  // Call the insert method in the Movie model
    }

    // Method to retrieve and display all movies
    public void displayMovies() {
        List<Movie> movies = Movie.showMovies();  // Call the showMovies method in the Movie model
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Rating: " + movie.getRating());
            System.out.println("Duration: " + movie.getDuration() + " mins");
            System.out.println("Synopsis: " + movie.getSynopsis());
            System.out.println("---------------------------------");
        }
    }
}
