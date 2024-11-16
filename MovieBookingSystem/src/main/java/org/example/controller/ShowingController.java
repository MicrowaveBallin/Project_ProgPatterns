package org.example.controller;

import org.example.model.Client;
import org.example.model.Showing;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowingController extends Controller {
    public ShowingController(Connection connection) {
        super(connection);
    }

    // Method to insert a new showing
    public boolean insertShowing(Showing showing) {
        String sql = "INSERT INTO Showing (showingId, movieId, theaterId, showTime) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, showing.getShowingId());
            pstmt.setInt(2, showing.getMovieId());
            pstmt.setInt(3, showing.getTheaterId());
            pstmt.setTimestamp(4, Timestamp.valueOf(showing.getShowTime()));
            pstmt.executeUpdate();
            System.out.println("Showing inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Method to retrieve all showings for a movie
    public void getShowingsForMovie(int movieId) {
        String sql = "SELECT * FROM Showing WHERE movieId = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Showing: Movie ID: " + rs.getInt("movieId") + ", Cinema Hall ID: " + rs.getInt("cinemaHallId") + ", Time: " + rs.getTimestamp("showTime"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    /*private DatabaseUtil db = new DatabaseUtil();
    private Map<Integer, Client> showings;

    public ShowingController(Connection connection) {
        super(connection);
        this.showings = new HashMap<>();
    }

    // Insert a new showing
    public void insertShowtime(int movieId, int theaterId, LocalDateTime showTime) {
        Timestamp timestamp = Timestamp.valueOf(showTime);

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
        List<Map<String, Object>> details = db.getRecordsShowing(sql, showtimeId);
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
}*/