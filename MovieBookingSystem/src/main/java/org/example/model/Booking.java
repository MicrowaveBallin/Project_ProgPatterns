package org.example.model;

public class Booking {
    private static int counter = 1;
    private int bookingId;
    private int userId;
    private int showTimeId;

    public Booking(int bookingId, int userId, int showTimeId) {
        counter++;
        this.bookingId = bookingId;
        this.userId = userId;
        this.showTimeId = showTimeId;
    }

    public Booking(int userId, int showTimeId) {
        this.bookingId = counter++;
        this.userId = userId;
        this.showTimeId = showTimeId;
    }


    // Getters and Setters
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
}