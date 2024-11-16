package org.example.controller;

import org.example.model.Payment;
import org.example.util.DatabaseUtil;

import java.sql.*;

public class PaymentController extends Controller {

    public PaymentController(Connection connection) {
        super(connection);
    }

    // Method to insert a new payment
    public boolean insertPayment(Payment payment) {
        String sql = "INSERT INTO Payment (paymentId, amount, accountId) VALUES (?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setBigDecimal(2, payment.getAmount());
            pstmt.setInt(3, payment.getAccountId());
            pstmt.executeUpdate();
            System.out.println("Payment inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Method to retrieve payment details
    public void getPaymentDetails(int bookingId) {
        String sql = "SELECT * FROM Payment WHERE bookingId = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookingId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Payment for booking " + rs.getInt("bookingId") + ": " + rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
