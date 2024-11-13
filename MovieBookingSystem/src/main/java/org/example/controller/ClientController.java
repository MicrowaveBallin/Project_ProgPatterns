package org.example.controller;

import org.example.model.Client;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.util.DatabaseUtil.connect;

public class ClientController {

    //TRYING EXPERIMENTAL FROM NOTES
    public boolean insertClient(Client client) {
        String sql = "INSERT INTO Customer (userId ,name, address, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DatabaseUtil.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getId());
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getAddress());
            pstmt.setString(4, client.getEmail());
            pstmt.setString(5, client.getPhone());
            pstmt.executeUpdate();
            System.out.println("Client inserted successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }


    //NOT WORKING YET OLD CODE
//    public void insertClient() {
//        String sql = "INSERT INTO Client(accountId, userId, password) VALUES (" +
//                this.id + "," + client.getId() + "," + this.password + ")";
//        Object[] values = {movieId, theaterId, showTime};
//        int rowsAffected = db.executeUpdate(sql, values);
//        if(rowsAffected > 0) {
//            System.out.println("Account added successfully");
//        } else {
//            System.out.println("Account added failed");
//        }


}
