package org.example.controller;

import org.example.model.Client;
import org.example.model.Theater;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController extends Controller {
    private DatabaseUtil db = new DatabaseUtil();
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
}
