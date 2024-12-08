package org.example.model;

import org.example.Enums.AccountStatus;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Account {
//    private int accountId; // Auto-incremented by the database
//    private int userId;
//    private String password;
//    private AccountStatus status;
//    private Client client;
//    private Map<Integer, Payment> paymentHistory; // Map of Payment objects
//
//    // Constructor for new account creation
//    public Account(Client client, String password) {
//        this.userId = client.getId();
//        this.password = password;
//        this.status = AccountStatus.ACTIVE;
//        this.paymentHistory = new HashMap<>();
//    }
//
//    // Constructor for loading account from the database
//    public Account(int accountId, int userId, String password, String status) {
//        this.accountId = accountId;
//        this.userId = userId;
//        this.password = password;
//        this.status = AccountStatus.valueOf(status);
//        this.paymentHistory = new HashMap<>();
//    }
//
//    // Insert this account into the database
//    public boolean insertAccount() {
//        String sql = "INSERT INTO Account(userId, password, status) VALUES (?, ?, ?)";
//        try (Connection conn = DatabaseUtil.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, this.userId);
//            stmt.setString(2, this.password);
//            stmt.setString(3, this.status.name());
//            int rowsAffected = stmt.executeUpdate();
//            return rowsAffected > 0; // Returns true if insert was successful
//        } catch (SQLException e) {
//            System.err.println("Error inserting account: " + e.getMessage());
//            return false;
//        }
//    }
//
//    // Getter and Setter methods
//    public Map<Integer, Payment> getPaymentHistory() {
//        return paymentHistory;
//    }
//
//    public void setPaymentHistory(Map<Integer, Payment> paymentHistory) {
//        this.paymentHistory = paymentHistory;
//    }
//
//    public AccountStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AccountStatus status) {
//        this.status = status;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(int accountId) {
//        this.accountId = accountId;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "Account{accountId=%d, userId=%d, status=%s}",
//                accountId,
//                userId,
//                status
//        );
//    }
}