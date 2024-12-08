package org.example.util;

import java.sql.*;

public class DatabaseUtil {
    private static final String BASE_URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    //private static final String USERNAME = "your_db_username";
    //private static final String PASSWORD = "your_db_password";

    // Static connection instance, created when the class is loaded
    private static Connection connection = connect();



    // ======================= TABLES =========================

    private static final String CLIENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Client (
            userId INTEGER PRIMARY KEY AUTOINCREMENT,
            name VARCHAR(255) NOT NULL,
            password VARCHAR(255) NOT NULL,
            address VARCHAR(255),
            email VARCHAR(255) UNIQUE NOT NULL,
            phone VARCHAR(15)
            );
            """;

    private static final String PAYMENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Payment (
            paymentId INTEGER PRIMARY KEY AUTOINCREMENT,
            userId INTEGER NOT NULL,
            amount DECIMAL(10,2) NOT NULL,
            FOREIGN KEY (userId) REFERENCES Client(userId) ON DELETE CASCADE
            );
            """;

    private static final String MOVIE_TABLE = """
            CREATE TABLE IF NOT EXISTS Movie (
            movieId INTEGER PRIMARY KEY AUTOINCREMENT,
            title VARCHAR(255) NOT NULL,
            genre VARCHAR(255),
            rating DECIMAL(3,2) CHECK (rating >= 0.0 AND rating <= 10.0),
            duration INTEGER CHECK (duration > 0),
            synopsis TEXT
            );
            """;

    private static final String SHOWTIME_TABLE = """
            CREATE TABLE IF NOT EXISTS ShowTime (
            showTimeId INTEGER PRIMARY KEY AUTOINCREMENT,
            movieId INTEGER NOT NULL,
            showDateTime DATETIME NOT NULL,
            hallNumber INTEGER CHECK (hallNumber > 0),
            FOREIGN KEY (movieId) REFERENCES Movie(movieId) ON DELETE CASCADE
            );
            """;

    private static final String BOOKING_TABLE = """
            CREATE TABLE IF NOT EXISTS Booking (
            bookingId INTEGER PRIMARY KEY AUTOINCREMENT,
            userId INTEGER NOT NULL,
            showTimeId INTEGER NOT NULL,
            FOREIGN KEY (userId) REFERENCES Client(userId) ON DELETE CASCADE,
            FOREIGN KEY (showTimeId) REFERENCES ShowTime(showTimeId) ON DELETE CASCADE
            );
            """;

    // =========================== GENERAL =================================

    // Method to get a connection to the SQLite database
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = connect();  // Reconnect if the connection is closed or null
            }
        } catch (SQLException e) {
            System.err.println("Error checking connection status: " + e.getMessage());
        }
        return connection;
    }

    // Private method to establish connection to the database
    private static Connection connect() {
        try {
            return DriverManager.getConnection(BASE_URL);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Method to create all the tables in the database
    public static void createAllTables() {
        // Execute each table creation SQL
        executeSql(CLIENT_TABLE);
        executeSql(PAYMENT_TABLE);
        executeSql(MOVIE_TABLE);
        executeSql(SHOWTIME_TABLE);
        executeSql(BOOKING_TABLE);
    }

    // Helper method to execute a single SQL command
    private static boolean executeSql(String sql) {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table created or already exists.");
            return true;
        } catch (SQLException e) {
            System.err.println("Failed to execute SQL: " + sql);
            System.err.println(e.getMessage());
        }
        return false;
    }


    public static void insertMovies() {
        String insertSql = """
        INSERT INTO Movie (title, genre, rating, duration, synopsis) VALUES
        ('The Shawshank Redemption', 'Drama', 9.3, 142, 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.'),
        ('The Godfather', 'Crime, Drama', 9.2, 175, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
        ('The Dark Knight', 'Action, Crime, Drama', 9.0, 152, 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.'),
        ('Pulp Fiction', 'Crime, Drama', 8.9, 154, 'The lives of two mob hitmen, a boxer, a gangster''s wife, and a pair of diner bandits intertwine in four tales of violence and redemption.'),
        ('The Lord of the Rings: The Return of the King', 'Action, Adventure, Drama', 8.9, 201, 'Gandalf and Aragorn lead the World of Men against Sauron''s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.');
        """;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            if (conn != null && !conn.isClosed()) {
                pstmt.executeUpdate();
                System.out.println("Movies inserted successfully.");
            } else {
                System.err.println("Failed to get a valid database connection.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting movies: " + e.getMessage());
        }
    }

    public static void createShowTimesTable() {
        String query = "CREATE TABLE IF NOT EXISTS ShowTimes ("
                + "showTimeId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "movieTitle TEXT NOT NULL, "
                + "showtime TEXT NOT NULL)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}