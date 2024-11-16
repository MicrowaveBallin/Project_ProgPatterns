package org.example.controller;

import org.example.model.Payment;
import org.example.util.DatabaseUtil;

import java.sql.*;

public class PaymentController {




//    // Method to retrieve payment details
//    public void getPaymentDetails(int bookingId) {
//        String sql = "SELECT * FROM Payment WHERE bookingId = ?";
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, bookingId);
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                System.out.println("Payment for booking " + rs.getInt("bookingId") + ": " + rs.getDouble("amount"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
