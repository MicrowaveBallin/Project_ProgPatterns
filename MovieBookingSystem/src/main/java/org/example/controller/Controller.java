package org.example.controller;

import java.sql.Connection;

public abstract class Controller {

    Connection connection;

    public Controller(Connection connection) {

        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
