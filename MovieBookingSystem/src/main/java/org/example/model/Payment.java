package org.example.model;

public class Payment {
    private int paymentId;
    private double amount;
    private int accountId;

    public Payment(int paymentId, double amount, int accountId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.accountId = accountId;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
