package org.example.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestDBController {
    private static final String DATABASE_URL = "jdbc:sqlite:./src/main/resources/database/database.db";
    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.WriteLock WRITE_LOCK = LOCK.writeLock();
    private static final ReentrantReadWriteLock.ReadLock READ_LOCK = LOCK.readLock();

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDepartmentTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS department (
                    department_id INTEGER PRIMARY KEY,
                    department_name TEXT NOT NULL
                )
                """;

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
