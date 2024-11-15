package org.example.controller;

import org.example.model.Client;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowingController extends Controller {
    private DatabaseUtil db = new DatabaseUtil();
    private Map<Integer, Client> showings;

    public ShowingController(Connection connection) {
        super(connection);
        this.showings = new HashMap<>();
    }

    // Insert a new showing
    public void insertShowtime(int movieId, int theaterId, Timestamp showTime) {
        String sql = "INSERT INTO Showing(movieId, theaterId, showTime) VALUES(?, ?, ?)";
        Object[] values = {movieId, theaterId, showTime};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0) {
            System.out.println("Showing added successfully");
        } else {
            System.out.println("Something went wrong. Showing not inserted.");
        }
    }

    // Display all showings
    public void displayShowings() {
        String sql = "SELECT * FROM Showing";
        List<Map<String, Object>> showings = db.getRecords(sql);
        for (Map<String, Object> showing : showings) {
            System.out.println("Showtime ID: " + showing.get("showingId"));
            System.out.println("Movie ID: " + showing.get("movieId"));
            System.out.println("Theater ID: " + showing.get("theaterId"));
            System.out.println("Showtime: " + showing.get("showTime"));
            System.out.println("-----------------------------");
        }
    }

    // Display details of a specific showing
    public void showShowtimeDetails(int showtimeId) {
        String sql = "SELECT s.showingId, m.title, m.duration, s.showTime FROM Showing s JOIN Movie m ON s.movieId = m.movieId WHERE s.showingId = ?";
        List<Map<String, Object>> details = db.getRecords(sql, showtimeId);
        if (!details.isEmpty()) {
            for (Map<String, Object> detail : details) {
                System.out.println("Showtime ID: " + detail.get("showingId"));
                System.out.println("Movie Title: " + detail.get("title"));
                System.out.println("Movie Duration: " + detail.get("duration"));
                System.out.println("Showtime: " + detail.get("showTime"));
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No details found for Showtime ID: " + showtimeId);
        }
    }

    // Get theater capacity for a specific showing
    public int getTheaterCapacity(int showtimeId) {
        String sql = "SELECT seatingCapacity FROM Theaters WHERE theaterId = (SELECT theaterId FROM Showing WHERE showingId = ?)";
        return db.getSeatingCapacity(sql, showtimeId);
    }
}
