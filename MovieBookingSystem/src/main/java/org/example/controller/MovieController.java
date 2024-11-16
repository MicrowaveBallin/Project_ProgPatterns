package org.example.controller;

import org.example.model.Client;
import org.example.model.Movie;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController extends Controller {
    public MovieController(Connection connection) {
        super(connection);
    }

    // Method to insert a new movie
    public boolean insertMovie(Movie movie) {
        String sql = "INSERT INTO Movie (title, genre, duration) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setInt(3, movie.getDuration());
            pstmt.executeUpdate();
            System.out.println("Movie inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Method to retrieve all movies
    public void getAllMovies() {
        String sql = "SELECT * FROM Movie";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Movie: " + rs.getString("title") + " | Genre: " + rs.getString("genre") + " | Duration: " + rs.getInt("duration"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    /*private Map<Integer, Client> movies;

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
}*/