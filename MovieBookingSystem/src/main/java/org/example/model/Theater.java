package org.example.model;

import org.example.util.DatabaseUtil;

import java.util.List;
import java.util.Map;

public class Theater {
    private String Location;
    private int SeatingCapacity;

    public Theater() {

    }

    private DatabaseUtil db = new DatabaseUtil();

    public void insertTheater(String location, int seatingCapacity) {
        this.Location = location;
        this.SeatingCapacity = seatingCapacity;
        String sql = "INSERT INTO Theater (Location, SeatingCapacity) VALUES (?, ?)";
        Object[] values = {Location, seatingCapacity};
        int rowsAffected = db.executeUpdate(sql,values);
        if(rowsAffected > 0) {
            System.out.println("Movies inserted successfully");
        } else {
            System.out.println("Movies insert failed");
        }
        }
    public void showTheaters() {
        String sql = "SELECT * FROM Theater";
        List<Map<String,Object>> Theater = db.getRecords(sql);
        for(Map<String, Object> theater : Theater) {
            System.out.println("TheaterID: " + theater.get("TheaterID"));
            System.out.println("Location: " + theater.get("Location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------------------------------------");
        }
    }
}
