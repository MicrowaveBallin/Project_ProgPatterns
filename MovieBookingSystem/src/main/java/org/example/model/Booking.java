package org.example.model;

import org.example.controller.ShowingController;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    private int bookingId;
    private int userId;
    private int showTimeId;
    private DatabaseUtil db;

    public Booking() {
        db = new DatabaseUtil();
    }

    // Getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }

    // Method to create a booking in the database
    public boolean createBooking(int userId, int showTimeId, int seatChoice) {
        String sql = "INSERT INTO Booking(userId, showTimeId) VALUES(?, ?)";
        Object[] values = {userId, showTimeId};
        int rowsAffected = DatabaseUtil.executeUpdate(sql, values);

        return rowsAffected > 0;
    }

    // Method to retrieve all bookings for a user
    public void getAllBookingsForUser(int userId) {
        String sql = "SELECT * FROM Booking WHERE userId = ?";
        DatabaseUtil.executeUpdate(sql, new Object[]{userId});
    }

    // Method to cancel a booking
    public boolean cancelBooking(int bookingId) {
        String sql = "DELETE FROM Booking WHERE bookingId = ?";
        int rowsAffected = DatabaseUtil.executeUpdate(sql, new Object[]{bookingId});
        return rowsAffected > 0;
    }
}