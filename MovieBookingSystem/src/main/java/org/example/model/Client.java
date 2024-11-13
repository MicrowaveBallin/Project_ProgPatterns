package org.example.model;

import org.example.util.DatabaseUtil;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.util.DatabaseUtil.connect;

public class Client extends Person {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;

    //without id
    public Client(String name, String address, String email, String phone) {
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    //with id, for creation from database
    public Client(int id, String name,String address, String email, String phone) {
        idCounter++;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
