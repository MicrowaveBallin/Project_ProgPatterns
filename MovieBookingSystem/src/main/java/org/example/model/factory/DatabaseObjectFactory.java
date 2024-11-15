package org.example.model.factory;

import org.example.model.Account;
import org.example.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseObjectFactory {

    public static Client createClient(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("userId"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone")
        );
    }

    public static Account createAccount(ResultSet rs) throws SQLException {
        return new Account(
                rs.getInt("accountId"),
                rs.getInt("userId"),
                rs.getString("password")
                //rs.getString("status")
        );
    }




}
