package org.example.model;

import java.math.BigDecimal;

public class Payment {
    private static int counter = 1;
    private int paymentId;
    private int clientId;
    private double amount;

    public Payment(int paymentId, double amount, int clientId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.clientId = clientId;
    }

    public Payment(int clientId, double amount) {
        this.paymentId = counter++;
        this.clientId = clientId;
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", clientId=" + clientId +
                ", amount=" + amount +
                '}';
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int accountId) {
        this.clientId = accountId;
    }




}

