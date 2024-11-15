package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import static org.example.util.DatabaseUtil.connect;

public class Movie {
    //WORKING

    private String title;
    private String genre;
    private double rating;
    private int duration;
    private String synopsis;

    // Constructor to initialize the Movie object
    public Movie(String title, int duration, double rating, String genre, String synopsis) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    // Constructor for retrieving movie details from database
    public Movie(String title, String genre, double rating, int duration, String synopsis) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    // Method to insert a movie into the Movies table in the database
    public void insertMovie() {
        String sql = "INSERT INTO Movie (title, genre, rating, duration, synopsis) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setDouble(3, rating);
            pstmt.setInt(4, duration);
            pstmt.setString(5, synopsis);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Movie inserted successfully");
            } else {
                System.out.println("Movie not inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting movie: " + e.getMessage());
        }
    }

    // Method to retrieve and display all movies from the Movies table
    public static List<Movie> showMovies() {
        String sql = "SELECT * FROM Movie";
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getString("Title"),
                        rs.getString("Genre"),
                        rs.getDouble("Rating"),
                        rs.getInt("Duration"),
                        rs.getString("Synopsis")
                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving movies: " + e.getMessage());
        }
        return movies;
    }

    // Getter methods for Movie details
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }
}