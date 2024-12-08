package org.example.controller;

import org.example.model.Client;
import org.example.model.factory.DatabaseObjectFactory;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.example.util.DatabaseUtil.connect;

public class ClientController {

    public void createClient(Client client) {
        String query = "INSERT INTO Client (name, password, address, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getPassword());
            pstmt.setString(3, client.getAddress());
            pstmt.setString(4, client.getEmail());
            pstmt.setString(5, client.getPhone());

            pstmt.executeUpdate();
            System.out.println("Client created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}