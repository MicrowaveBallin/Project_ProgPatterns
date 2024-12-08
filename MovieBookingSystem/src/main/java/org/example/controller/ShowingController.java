package org.example.controller;

import org.example.model.Client;
import org.example.model.Showing;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowingController {
    public void createShowTime(Showing showTime) {
        String query = "INSERT INTO Showing (movieId, showDateTime, hallNumber) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, showTime.getMovieId());
            pstmt.setObject(2, showTime.getShowDateTime());
            pstmt.setInt(3, showTime.getHallNumber());

            pstmt.executeUpdate();
            System.out.println("ShowTime created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}