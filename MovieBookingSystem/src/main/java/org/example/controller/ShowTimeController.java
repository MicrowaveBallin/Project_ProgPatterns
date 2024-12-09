package org.example.controller;

import org.example.model.ShowTime;
import org.example.util.DatabaseUtil;
import java.sql.*;

public class ShowTimeController {



    // Method to add a showtime to the database
    public static boolean addShowtime(ShowTime showTime) {
        String query = "INSERT INTO ShowTime (showTimeId, movieId, showDateTime) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, showTime.getShowTimeId());
            pstmt.setInt(2, showTime.getMovieId());
            pstmt.setString(3, showTime.getShowDateTime());
            int result = pstmt.executeUpdate();

            return result > 0; // If insertion was successful
        } catch (SQLException e) {
            System.err.println("Error adding showtime: " + e.getMessage()); // Print detailed error message
            e.printStackTrace();
        }
        return false;
    }

    // Method to remove a showtime for a given movie and showtime
    public static boolean removeShowtime(ShowTime showTime) {
        String query = "DELETE FROM ShowTime WHERE movieId = ? AND showDateTime = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, showTime.getMovieId());
            pstmt.setString(2, showTime.getShowDateTime());
            int result = pstmt.executeUpdate();

            return result > 0; // If deletion was successful
        } catch (SQLException e) {
            System.err.println("Error removing showtime: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }




//    // Method to add a showtime to the database
//    public static boolean addShowtime(int movieId, String showDateTime) {
//        String query = "INSERT INTO ShowTime (movieId, showDateTime) VALUES (?, ?)";
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//
//            pstmt.setInt(1, movieId);
//            pstmt.setString(2, showDateTime);
//            int result = pstmt.executeUpdate();
//
//            return result > 0; // If insertion was successful
//        } catch (SQLException e) {
//            System.err.println("Error adding showtime: " + e.getMessage()); // Print detailed error message
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    // Method to remove a showtime for a given movie and showtime
//    public static boolean removeShowtime(String movieTitle, String showtime) {
//        String query = "DELETE FROM ShowTime WHERE movieTitle = ? AND showtime = ?";
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)) {
//
//            pstmt.setString(1, movieTitle);
//            pstmt.setString(2, showtime);
//            int result = pstmt.executeUpdate();
//
//            return result > 0; // If deletion was successful
//        } catch (SQLException e) {
//            System.err.println("Error removing showtime: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return false;
//    }



}