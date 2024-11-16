package org.example.model;

import java.math.BigDecimal;

public class Payment {
    private int paymentId;
    private BigDecimal amount;
    private int accountId;

    public Payment(int paymentId, BigDecimal amount, int accountId) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
