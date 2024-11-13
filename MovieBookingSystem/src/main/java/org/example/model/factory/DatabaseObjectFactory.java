package org.example.model.factory;

import org.example.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseObjectFactory {

    public static Client createCustomer(ResultSet rs) throws SQLException {
        return new Client(
                rs.getInt("userId"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("email"),
                rs.getString("phone")
        );
    }


}
