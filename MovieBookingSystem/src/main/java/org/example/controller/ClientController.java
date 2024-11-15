package org.example.controller;

import org.example.model.Client;
import org.example.model.factory.DatabaseObjectFactory;
import org.example.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.util.DatabaseUtil.connect;

public class ClientController extends Controller {

    private Map<Integer, Client> clients; ///MAP MAYBE???????????

    //WARNINGS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //Move database stuff into DatabaseUtil???

    public ClientController(Connection connection) {

        super(connection);
        this.clients = new HashMap<>();
    }


    //TRYING EXPERIMENTAL FROM NOTES
    public boolean insertClient(Client client) {
        String sql = "INSERT INTO Client (userId ,name, password, address, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = DatabaseUtil.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, client.getId());
            pstmt.setString(2, client.getName());
            pstmt.setString(3, client.getPassword());
            pstmt.setString(4, client.getAddress());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getPhone());
            pstmt.executeUpdate();
            System.out.println("Client inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
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
