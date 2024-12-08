package org.example.model.factory;

import org.example.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DatabaseObjectFactory {

    public static Client createClient(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("userId"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone")
        );
    }

    public static Payment createPayment(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("paymentId"),
                rs.getInt("userId"),
                rs.getDouble("amount")
        );
    }

    public static Movie createMovie(ResultSet rs) throws SQLException {
        return new Movie(
                rs.getInt("movieId"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getDouble("rating"),
                rs.getInt("duration"),
                rs.getString("synopsis")
        );
    }

    public static Booking createBooking(ResultSet rs) throws SQLException {
        return new Booking(
                rs.getInt("bookingId"),
                rs.getInt("userId"),
                rs.getInt("showTimeId")
        );
    }

    public static Showing createShowing(ResultSet rs) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("showDateTime");
        LocalDateTime showDateTime = timestamp != null ? timestamp.toLocalDateTime() : null;
        return new Showing(
                rs.getInt("showTimeId"),
                rs.getInt("movieId"),
                showDateTime,
                rs.getInt("hallNumber")
        );
    }
}