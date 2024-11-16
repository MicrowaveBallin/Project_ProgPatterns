package org.example.controller;

import org.example.model.CinemaHall;
import org.example.util.DatabaseUtil;

import java.sql.*;

public class CinemaHallController extends Controller {

    public CinemaHallController(Connection connection) {
        super(connection);
    }

    // Method to insert a new CinemaHall
    public boolean insertCinemaHall(CinemaHall cinemaHall) {
        String sql = "INSERT INTO CinemaHall (cinemaHallId,theaterId, seatingCapacity) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cinemaHall.getCinemaHallId());
            pstmt.setInt(2, cinemaHall.getTheaterId());
            pstmt.setInt(3, cinemaHall.getSeatCapacity());
            pstmt.executeUpdate();
            System.out.println("CinemaHall inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Method to retrieve all cinema halls
    public void getAllCinemaHalls() {
        String sql = "SELECT * FROM CinemaHall";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("CinemaHall: " + rs.getString("hallName") + " | Capacity: " + rs.getInt("seatingCapacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
