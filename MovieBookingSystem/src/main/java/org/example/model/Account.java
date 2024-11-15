package org.example.model;

import org.example.Enums.AccountStatus;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Account {

    private static int idCounter = 1;
    private int id;
    private int clientId;
    private String password;
    private AccountStatus status;
    private Client client;
    private Map paymentHistory;


    public Account(Client client, String password) {
        this.id = idCounter++;
        this.clientId = client.getId();
        this.password = password;
        this.status = AccountStatus.ACTIVE;
        this.paymentHistory = new HashMap();
    }




    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public Map getPaymentHistory() {
        return paymentHistory;
    }
}





//NOT WORKING YET
//    public void insertAccount() {
//        String sql = "INSERT INTO Account(accountId, userId, password) VALUES (" +
//        this.id + "," + client.getId() + "," + this.password + ")";
//        Object[] values = {movieId, theaterId, showTime};
//        int rowsAffected = db.executeUpdate(sql, values);
//        if(rowsAffected > 0) {
//            System.out.println("Account added successfully");
//        } else {
//            System.out.println("Account added failed");
//        }
//well