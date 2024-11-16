package org.example.controller;

import org.example.model.Account;
import org.example.model.Client;
import org.example.model.factory.DatabaseObjectFactory;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AccountController extends Controller {

    private Map<Integer, Account> accounts;

    public AccountController(Connection connection) {
        super(connection);
        this.accounts = new HashMap<>();
    }


    //CHANGE
    public boolean insertAccount(Account account) {
        String sql = "INSERT INTO Account (userId, password, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, account.getUserId());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getStatus().toString());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        account.setAccountId(generatedKeys.getInt(1));
                    }
                }
                System.out.println("Account inserted successfully.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error inserting account: " + e.getMessage());
        }
        return false;
    }

//    // Method to fetch all accounts from the database
//    public Map<Integer, Account> getAccounts(Connection conn) {
//        Map<Integer, Account> accounts = new HashMap<>();
//        String sql = "SELECT * FROM Account";
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Account account = DatabaseObjectFactory.createAccount(rs);
//                accounts.put(account.getAccountId(), account);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error fetching accounts: " + e.getMessage());
//        }
//        return accounts;
//    }

//    // Method to fetch an account by ID from the database
//    public Account getAccountById(int accountId) {
//        String sql = "SELECT * FROM Account WHERE accountId = ?";
//        try (
//                Connection conn = DatabaseUtil.getConnection();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, accountId);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return DatabaseObjectFactory.createAccount(rs);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Error fetching account by ID: " + e.getMessage());
//        }
//        return null;
//    }

    // Method to update an account in the database
    public boolean updateAccount(Account account) {
        String sql = "UPDATE Account SET userId = ?, password = ? WHERE accountId = ?";
        try (
                Connection conn = DatabaseUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, account.getUserId());
            pstmt.setString(2, account.getPassword());
            pstmt.setInt(3, account.getAccountId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Account updated successfully.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error updating account: " + e.getMessage());
        }
        return false;
    }

    // Method to delete an account from the database
    public boolean deleteAccount(int accountId) {
        String sql = "DELETE FROM Account WHERE accountId = ?";
        try (
                Connection conn = DatabaseUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Account deleted successfully.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error deleting account: " + e.getMessage());
        }
        return false;
    }
}
//
////ACCOUNT
////move to util
//public static Map<Integer, Account> getAccount() {
//    //this.clients = new ArrayList<>();
//    String sql = "SELECT * FROM Account";
//    try (Statement stmt = connection.createStatement();
//         ResultSet rs = stmt.executeQuery(sql)) {
//        while (rs.next()) {
//            Account account = DatabaseObjectFactory.createAccount(rs);
//            accounts.put(account.getId(), account);
//        }
//    } catch (SQLException e) {
//        System.out.println("Error fetching clients: " + e.getMessage());
//    }
//    return accounts;
//}