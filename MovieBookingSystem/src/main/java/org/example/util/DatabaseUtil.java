package org.example.util;

import java.sql.*;

public class DatabaseUtil {
    private static final String BASE_URL = "jdbc:sqlite:./src/main/resources/data.db";

    private static final String USER_TABLE = """
            CREATE TABLE IF NOT EXISTS Users (
            userID INT AUTO_INCREMENT,
            username VARCHAR(255),
            Password VARCHAR(255),
            Name VARCHAR(255),
            phone VARCHAR(15),
            Address VARCHAR(255),
            PRIMARY KEY (UserID)
            );
            """;

    private static final String ADMIN_TABLE = """
            CREATE TABLE IF NOT EXISTS Admin (
            AdminID INT AUTO_INCREMENT,
            username VARCHAR(255),
            Password VARCHAR(255),
            PRIMARY KEY (AdminID)
            );
            """;

    private static final String THEATRES_TABLE = """
            CREATE TABLE IF NOT EXISTS Theaters (
            TheaterID INT AUTO_INCREMENT,
            Location VARCHAR(255),
            SeatingCapacity VARCHAR(255),
            PRIMARY KEY (TheaterID)
            );
            """;

    private static final String MOVIES_TABLE = """
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

    private static final String SHOWTIMES_TABLE = """
            CREATE TABLE IF NOT EXISTS Showtimes (
            ShowtimeID INT AUTO_INCREMENT,
            MovieID INT,
            TheaterID INT,
            Showtime DATETIME,
            PRIMARY KEY (ShowtimeID),
            FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
            FOREIGN KEY (TheaterID) REFERENCES Theaters(TheaterID)
            );
            """;

    private static final String BOOKINGS_TABLE = """
            CREATE TABLE IF NOT EXISTS Bookings(
            BookingID INT AUTO_INCREMENT,
            UserID INT,
            ShowtimeId INT,
            PaymentStatus BOOLEAN,
            primary KEY (BookingID),
            FOREIGN KEY (UserID) REFERENCES Users(UserID),
            FOREIGN KEY (ShowtimeID) REFERENCES Showtimes(ShowtimeID)
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
    
    public static boolean executeSql(String sql) {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Executed successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public int executeUpdate (String sql, Object[] values){
        int rowAffected = 0;
        try(Connection connection = connect();
        PreparedStatement ps = connection.prepareStatement(sql)){
            for(int i = 0; i < values.length; i++){
                ps.setObject(i + 1, values[i]);
            }
            rowAffected = ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rowAffected;
    }

    public ResultSet getRecords (String sql){
        ResultSet rs = null;
        try(Connection connection = connect();
            PreparedStatement ps = connection.prepareStatement(sql)){
            rs = ps.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public static void createAllTables() {
        executeSql(USER_TABLE);
        executeSql(ADMIN_TABLE);
        executeSql(THEATRES_TABLE);
        executeSql(MOVIES_TABLE);
        executeSql(SHOWTIMES_TABLE);
        executeSql(BOOKINGS_TABLE);
    }

    public static final String INSERT_SQL = """
            INSERT INTO students VALUES(1, "MIKE", 18)
   
    """;


}
