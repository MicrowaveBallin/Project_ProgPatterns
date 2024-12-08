package org.example.model;

public class Payment {
    private int paymentId;
    private int userId;
    private double amount;

    public Payment(int paymentId, int userId, double amount) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}