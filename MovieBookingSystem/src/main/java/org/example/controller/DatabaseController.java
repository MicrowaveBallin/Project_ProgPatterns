package org.example.controller;

import org.example.model.Client;
import org.example.model.Payment;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseController {





    //Client
    public static void insertClient(Client client) {
        String sql = "INSERT INTO Client (userId ,name, password, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = DatabaseUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, client.getId());
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getPassword());
            pstmt.setString(4, client.getAddress());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getPhone());
            pstmt.executeUpdate();
            System.out.println("Client inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isValidClient(Client client) {
        return client.getName() != null && !client.getName().isEmpty() &&
                client.getEmail() != null && client.getEmail().contains("@") &&
                client.getPhone() != null && client.getPhone().length() >= 12;
    }


    //Payment
    public static void insertPayment(Payment payment) {
        String sql = "INSERT INTO Payment (paymentId, userId, amount) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setInt(2, payment.getClientId());
            pstmt.setDouble(3, payment.getAmount());
            pstmt.executeUpdate();
            System.out.println("Payment inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
