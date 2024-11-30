package org.example.model;

import org.example.util.DatabaseUtil;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import static org.example.util.DatabaseUtil.connect;

public class Client extends Person {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String password;
    private String address;
    private String email;
    private String phone;
    private List<Payment> paymentHistory = new ArrayList<>();

    //without id
    public Client(String name, String password, String address, String email, String phone) {
        this.id = idCounter++;
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    //with id, for creation from database
    public Client(int id, String name, String password, String address, String email, String phone) {
        idCounter++;
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public void addPayment(double amount) {
        paymentHistory.add(new Payment(id,amount));
        //DatabaseUtil.insertPayment(payment);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Payment> getPaymentHistory() {
        return paymentHistory;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone +
                '}';
    }
}
