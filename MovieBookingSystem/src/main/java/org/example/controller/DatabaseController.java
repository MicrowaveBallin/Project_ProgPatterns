package org.example.controller;

import org.example.model.*;
import org.example.model.factory.DatabaseObjectFactory;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {

    // Client
    public static void insertClient(Client client) {
        if (!isValidClient(client)) {
            System.out.println("Client data is not valid.");
            return;
        }
        String sql = "INSERT INTO Client (userId, name, password, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, client.getUserId());
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getPassword());
            pstmt.setString(4, client.getAddress());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getPhone());
            pstmt.executeUpdate();
            System.out.println("Client inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting client: " + e.getMessage());
        }
    }

    private static boolean isValidClient(Client client) {
        return client.getUserId() > 0 && client.getName() != null && !client.getName().isEmpty() &&
                client.getEmail() != null && client.getEmail().contains("@");
    }

    // Payment
    public static void insertPayment(Payment payment) {
        String sql = "INSERT INTO Payment (paymentId, userId, amount) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setInt(2, payment.getUserId());
            pstmt.setDouble(3, payment.getAmount());
            pstmt.executeUpdate();
            System.out.println("Payment inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting payment: " + e.getMessage());
        }
    }

    // Movie
    public static void insertMovie(Movie movie) {
        String sql = "INSERT INTO Movie (movieId, title, genre, rating, duration, synopsis) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movie.getMovieId());
            pstmt.setString(2, movie.getTitle());
            pstmt.setString(3, movie.getGenre());
            pstmt.setDouble(4, movie.getRating());
            pstmt.setInt(5, movie.getDuration());
            pstmt.setString(6, movie.getSynopsis());
            pstmt.executeUpdate();
            System.out.println("Movie inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting movie: " + e.getMessage());
        }
    }

    // ShowTime
    public static void insertShowTime(Showing showTime) {
        String sql = "INSERT INTO ShowTime (showTimeId, movieId, showDateTime, hallNumber) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, showTime.getShowTimeId());
            pstmt.setInt(2, showTime.getMovieId());
            pstmt.setObject(3, Timestamp.valueOf(showTime.getShowDateTime()));  // Convert to Timestamp
            pstmt.setInt(4, showTime.getHallNumber());
            pstmt.executeUpdate();
            System.out.println("ShowTime inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting showtime: " + e.getMessage());
        }
    }

    // Booking
    public static void insertBooking(Booking booking) {
        String sql = "INSERT INTO Booking (bookingId, userId, showTimeId) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, booking.getBookingId());
            pstmt.setInt(2, booking.getUserId());
            pstmt.setInt(3, booking.getShowTimeId());
            pstmt.executeUpdate();
            System.out.println("Booking inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        }
    }








}