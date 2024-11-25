package org.example.controller;

import java.sql.*;

public class DatabaseController {
    private static final String DB_URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    //private static Connection connection;
    // Util
//    private static void connect() {
//        try {
//            System.out.println("connected to database");
//            connection = DriverManager.getConnection(DB_URL);
//        } catch (SQLException e) {
//            System.out.println("could not connect to database");
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static Connection getConnection() {
//        if (connection == null) {
//            connect();
//        }
//        return connection;
//    }
    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void execute(String sql) {
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
            System.out.println("successfully executed");
        } catch (SQLException e) {
            System.out.println("could not execute");
            throw new RuntimeException(e);
        }
    }

    // Tables
    private static final String BOOK_TABLE = """
            CREATE TABLE IF NOT EXISTS book (
            book_id INTEGER PRIMARY KEY,
            book_title TEXT,
            isbn TEXT,
            published_year TEXT
            )
            """;


    private static final String AUTHOR_TABLE = """
            CREATE TABLE IF NOT EXISTS author (
            author_id INTEGER PRIMARY KEY,
            author_name TEXT,
            birth_year TEXT
            )
            """;

    private static final String BOOKSAUTHORS_TABLE = """
            CREATE TABLE IF NOT EXISTS booksauthors (
            book_id INTEGER,
            author_id INTEGER,
            PRIMARY KEY (book_id, author_id),
            FOREIGN KEY (author_id) REFERENCES author(id),
            FOREIGN KEY (book_id) REFERENCES book(id)
            )
            """;

    public static void createAllTables() {
        execute(BOOK_TABLE);
        execute(AUTHOR_TABLE);
        execute(BOOKSAUTHORS_TABLE);
    }

    public static void insertIntoBook(int id, String title, String isbn, int year) {
        String sql = """
            INSERT INTO book (book_id, book_title, isbn, published_year) values (?, ?, ?, ?);
            """;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1,id);
            statement.setString(2,title);
            statement.setString(3,isbn);
            statement.setInt(4,year);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("could not insert into book");
            throw new RuntimeException(e);
        }
    }




}
