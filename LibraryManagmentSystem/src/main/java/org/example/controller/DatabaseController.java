package org.example.controller;

import org.example.model.Author;
import org.example.model.Book;

import java.sql.*;

public class DatabaseController {
    private static final String DB_URL = "jdbc:sqlite:./src/main/resources/database/data.db";


    // Util
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
            FOREIGN KEY (author_id) REFERENCES author(author_id),
            FOREIGN KEY (book_id) REFERENCES book(book_id)
            )
            """;

    public static void createAllTables() {
        execute(BOOK_TABLE);
        execute(AUTHOR_TABLE);
        execute(BOOKSAUTHORS_TABLE);
    }


    // Executions
    public static void insertIntoBook(Book book) {
        String sql = """
            INSERT INTO book (book_id, book_title, isbn, published_year) values (?, ?, ?, ?);
            """;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1,book.getId());
            statement.setString(2,book.getTitle());
            statement.setString(3,book.getIsbn());
            statement.setInt(4,book.getPublishYear());
            statement.executeUpdate();
            System.out.println("inserted into books");
        } catch (SQLException e) {
            System.out.println("could not insert into book");
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoAuthor(Author author) {
        String sql = """
            INSERT INTO author (author_id, author_name, birth_year) values (?, ?, ?);
            """;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1,author.getId());
            statement.setString(2,author.getName());
            statement.setInt(3,author.getBirthYear());
            statement.executeUpdate();
            System.out.println("inserted into authors");
        } catch (SQLException e) {
            System.out.println("could not insert into authors");
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoBooksAuthors(Book book, Author author) {
        String sql = """
            INSERT INTO booksauthors (book_id, author_id) values (?, ?);
            """;

        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, book.getId());
            statement.setInt(2, author.getId());
            statement.executeUpdate();
            System.out.println("inserted into booksauthors");
        } catch (SQLException e) {
            System.out.println("couldnt insert into booksauthors");
            throw new RuntimeException(e);
        }
    }






}
