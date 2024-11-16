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
                //createPayment(rs.getInt("userId"));
        );
    }

//    public static Account createAccount(ResultSet rs) throws SQLException {
//        return new Account(
//                rs.getInt("accountId"),
//                rs.getInt("userId"),
//                rs.getString("password"),
//                rs.getString("status")
//        );
//    }

    public static Payment createPayment(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("paymentId"),
                rs.getDouble("amount"),
                rs.getInt("userId")
        );
    }

    public static Movie createMovie(ResultSet rs) throws SQLException {
        return new Movie(
                rs.getInt("movieId"),
                rs.getString("title"),
                rs.getInt("duration"),
                rs.getDouble("rating"),
                rs.getString("genre"),
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

    public static CinemaHall createCinemaHall(ResultSet rs) throws SQLException {
        return new CinemaHall(
                rs.getInt("cinemaHallId"),
                rs.getInt("theaterId"),
                rs.getInt("seatingCapacity")
        );
    }

    public static Showing createShowing(ResultSet rs) throws SQLException {
        Timestamp timestamp = rs.getTimestamp("showTime");
        LocalDateTime showTime = timestamp != null ? timestamp.toLocalDateTime() : null; // Convert Timestamp to LocalDateTime
        return new Showing(
                rs.getInt("showingId"),
                rs.getInt("movieId"),
                rs.getInt("theaterId"),
                showTime
        );
    }

    public static Theater createTheater(ResultSet rs) throws SQLException {
        return new Theater(
                rs.getInt("theaterId"),
                rs.getString("theaterName"),
                rs.getString("location") // Add other Theater properties if necessary
        );
    }


//    public static Payment createPayment(ResultSet rs) throws SQLException {
//        return new Payment();
//    }


//    public static Account createAccount(ResultSet rs) throws SQLException {
//        return new Account(
//                rs.getInt("accountId"),
//                rs.getInt("userId"),
//                rs.getString("password")
//                //rs.getString("status")
//        );
//    }




}
