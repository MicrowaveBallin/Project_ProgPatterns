package org.example.controller;

import org.example.model.Client;
import org.example.model.Movie;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController  {
    public void createMovie(Movie movie) {
        String query = "INSERT INTO Movie (title, genre, rating, duration, synopsis) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setDouble(3, movie.getRating());
            pstmt.setInt(4, movie.getDuration());
            pstmt.setString(5, movie.getSynopsis());

            pstmt.executeUpdate();
            System.out.println("Movie created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}