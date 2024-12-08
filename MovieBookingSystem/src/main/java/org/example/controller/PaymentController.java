package org.example.controller;

import org.example.model.Payment;
import org.example.util.DatabaseUtil;

import java.sql.*;

public class PaymentController {
    public void createPayment(Payment payment) {
        String query = "INSERT INTO Payment (userId, amount) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, payment.getUserId());
            pstmt.setDouble(2, payment.getAmount());

            pstmt.executeUpdate();
            System.out.println("Payment created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
