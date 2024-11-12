package org.example.model;

import org.example.util.DatabaseUtil;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.util.DatabaseUtil.connect;

public class Client extends Person {

    private static int idCounter = 0;
    private String id = "";
    private String name;
    private String address;
    private String email;
    private String phone;

    public Client(String name, String address, String email, String phone) {
        this.id += idCounter++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    //TRYIMG EXPERIMENTAL FROM NOTES
//    String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
//
//    try (
//    Connection conn = connect();
//    PreparedStatement pstmt = conn.prepareStatement(sql)) {
//        pstmt.setString(1, name);
//        pstmt.setInt(2, age);
//        pstmt.executeUpdate();
//        System.out.println("Data inserted successfully.");
//    } catch (
//    SQLException e) {
//        System.out.println(e.getMessage());
//    }

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



    public String getId() {
        return id;
    }
}
