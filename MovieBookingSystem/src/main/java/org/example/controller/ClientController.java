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

    private Map<Integer, Client> clients = new HashMap<>(); ///MAP MAYBE???????????


    //WARNINGS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //Move database stuff into DatabaseUtil???


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