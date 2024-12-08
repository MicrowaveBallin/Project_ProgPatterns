package org.example.controller;

import org.example.model.Booking;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingController {

    // Method to create a booking entry in the Booking table
    public void createBooking(Booking booking) {
        String query = "INSERT INTO Booking (userId, showTimeId) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();  // Use the static connection from DatabaseUtil
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the parameters for the query
            pstmt.setInt(1, booking.getUserId());
            pstmt.setInt(2, booking.getShowTimeId());

            // Execute the query to insert the booking
            pstmt.executeUpdate();
            System.out.println("Booking created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating booking: " + e.getMessage());
            e.printStackTrace();
        }
    }
}