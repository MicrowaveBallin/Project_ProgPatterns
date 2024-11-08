package org.example.model;

import org.example.Enums.AccountStatus;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int idCounter = 0;
    private String id;
    private String password;
    private AccountStatus status;
    private Map paymentHistory;


    public Account(String password) {
        this.id = String.valueOf(idCounter++);
        this.password = password;
        this.status = AccountStatus.ACTIVE;
        this.paymentHistory = new HashMap();
    }
}
//well