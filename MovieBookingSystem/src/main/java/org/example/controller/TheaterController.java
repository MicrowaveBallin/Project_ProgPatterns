package org.example.controller;

import org.example.model.Client;
import org.example.model.Theater;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController extends Controller {
    public TheaterController(Connection connection) {
        super(connection);
    }

    // Method to insert a new theater
    public boolean insertTheater(Theater theater) {
        String sql = "INSERT INTO Theater (theaterId, theaterName, location) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, theater.getTheaterId());
            pstmt.setString(2, theater.getTheaterName());
            pstmt.setString(3, theater.getLocation());
            pstmt.executeUpdate();
            System.out.println("Theater inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Method to retrieve all theaters
    public void getAllTheaters() {
        String sql = "SELECT * FROM Theater";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Theater: " + rs.getString("name") + " | Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
    /*private DatabaseUtil db = new DatabaseUtil();
    private Map<Integer, Client> theaters;

    public TheaterController(Connection connection) {
        super(connection);
        this.theaters = new HashMap<>();
    }

    // Insert a new theater
    public void insertTheater(String location, int seatingCapacity) {
        String sql = "INSERT INTO Theater (Location, SeatingCapacity) VALUES (?, ?)";
        Object[] values = {location, seatingCapacity};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0) {
            System.out.println("Theater inserted successfully");
        } else {
            System.out.println("Theater insertion failed");
        }
    }

    // Display all theaters
    public void showTheaters() {
        String sql = "SELECT * FROM Theater";
        List<Map<String, Object>> theaters = db.getRecords(sql);
        for (Map<String, Object> theater : theaters) {
            System.out.println("Theater ID: " + theater.get("TheaterID"));
            System.out.println("Location: " + theater.get("Location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------------------------------------");
        }
    }
}*/