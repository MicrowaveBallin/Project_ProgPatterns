package org.example.util;

import java.sql.*;

public class DatabaseUtil {
    private static final String BASE_URL = "jdbc:sqlite:./src/main/resources/database/data.db";

    private static final String ACCOUNT_TABLE = """
            CREATE TABLE IF NOT EXISTS Account (
            accountId INT AUTO_INCREMENT,
            password VARCHAR(255),
            status VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            PRIMARY KEY (accountId)
            );
            """;

    private static final String PAYMENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Payment (
            paymentId INT AUTO_INCREMENT,
            password VARCHAR(255),
            status VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            PRIMARY KEY (paymentId)
            FOREIGN KEY (accountId)
            );
            """;

    private static final String CUSTOMER_TABLE = """
            CREATE TABLE IF NOT EXISTS Customer (
            userId INT AUTO_INCREMENT,
            name VARCHAR(255),
            address VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            accountId VARCHAR(255),
            PRIMARY KEY (userId)
            FOREIGN KEY (accountId)
            );
            """;
    ///CUSTOMER TYPE??

    private static final String BOOKING_TABLE = """
            CREATE TABLE IF NOT EXISTS Booking (
            bookingId INT AUTO_INCREMENT,
            userId INT,
            showTimeId INT,
            PRIMARY KEY (bookingId),
            FOREIGN KEY (userId) REFERENCES Users(UserId),
            FOREIGN KEY (showTimeId) REFERENCES ShowTimes(showTimeId)
            );
            """;

    private static final String THEATRE_TABLE = """
            CREATE TABLE IF NOT EXISTS Theater (
            theaterID INT AUTO_INCREMENT,
            location VARCHAR(255),
            SeatingCapacity VARCHAR(255),
            PRIMARY KEY (TheaterID)
            );
            """;

    private static final String SHOWTIME_TABLE = """
            CREATE TABLE IF NOT EXISTS ShowTimes (
            ShowtimeID INT AUTO_INCREMENT,
            MovieID INT,
            TheaterID INT,
            Showtime DATETIME,
            PRIMARY KEY (ShowtimeID),
            FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
            FOREIGN KEY (TheaterID) REFERENCES Theaters(TheaterID)
            );
            """;

    private static final String ADMIN_TABLE = """
            CREATE TABLE IF NOT EXISTS Admin (
            adminID INT AUTO_INCREMENT,
            username VARCHAR(255),
            Password VARCHAR(255),
            PRIMARY KEY (adminID)
            );
            """;

    private static final String MOVIE_TABLE = """
            CREATE TABLE IF NOT EXISTS Movies (
            MovieID INT AUTO_INCREMENT,
            Title VARCHAR(255),
            Genre VARCHAR(255),
            Rating DECIMAL(3,2),
            Duration INT,
            Synopsis TEXT,
            PRIMARY KEY (MovieID)
            );
            """;

    public static Connection connect() {
        Connection connection = null; ///????  null
        try {
            connection = DriverManager.getConnection(BASE_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private static boolean executeSql(String sql) {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Executed successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void createAllTables() {
//        executeSql(USER_TABLE);
//        executeSql(ADMIN_TABLE);
//        executeSql(THEATRES_TABLE);
//        executeSql(MOVIES_TABLE);
//        executeSql(SHOWTIMES_TABLE);
//        executeSql(BOOKINGS_TABLE);
    }

    public static final String INSERT_SQL = """
            INSERT INTO students VALUES(1, "MIKE", 18)
   
    """;


}
