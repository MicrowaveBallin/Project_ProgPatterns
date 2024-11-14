package org.example.controller;

import org.example.model.Account;
import org.example.model.Client;
import org.example.model.factory.DatabaseObjectFactory;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.Map;

public class AccountController extends Controller {

    private Map<Integer, Account> accounts;

    public AccountController(Connection connection) {
        super(connection);
    }



//    public Map<Integer, Client> getAccount() {
//        //this.clients = new ArrayList<>();
//        String sql = "SELECT * FROM Account";
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Client client = DatabaseObjectFactory.createCustomer(rs);
//                clients.put(client.getId(), client);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error fetching clients: " + e.getMessage());
//        }
//        return clients;
//    }
//
//
//    //CHANGE
//    public boolean insertClient(Client client) {
//        String sql = "INSERT INTO Customer (userId ,name, address, email, phone) VALUES (?, ?, ?, ?, ?)";
//        try (
//                Connection conn = DatabaseUtil.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, client.getId());
//            pstmt.setString(2, client.getName());
//            pstmt.setString(3, client.getAddress());
//            pstmt.setString(4, client.getEmail());
//            pstmt.setString(5, client.getPhone());
//            pstmt.executeUpdate();
//            System.out.println("Client inserted successfully.");
//            return true;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }

}
