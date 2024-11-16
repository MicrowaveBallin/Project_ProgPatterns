package org.example.model;

import org.example.Enums.AccountStatus;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int idCounter = 1;
    private int accountId;
    private int userId;
    private String password;
    private AccountStatus status;
    private Client client;
    private Map<Integer, Payment> paymentHistory;  // Specified type parameters

    public Account(Client client, String password) {
        this.accountId = idCounter++;
        this.userId = client.getId();
        this.password = password;
        this.status = AccountStatus.ACTIVE;
        this.paymentHistory = new HashMap<>();
    }

    public Account(int accountId, int userId, String password, String status) {
        this.accountId = accountId;
        this.userId = userId;
        this.password = password;
        this.status = AccountStatus.valueOf(status);
        this.paymentHistory = new HashMap<>();
    }

    // Getters and setters remain the same, but update Map to be typed
    public Map<Integer, Payment> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(Map<Integer, Payment> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return String.format(
                "Account{accountId=%d, userId=%d, status=%s}",
                accountId,
                userId,
                status
        );
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