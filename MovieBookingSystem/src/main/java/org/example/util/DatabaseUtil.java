package org.example.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
    private static final String BASE_URL = "jdbc:sqlite:C:\\Users\\santh\\Documents\\GitHub\\Project_ProgPatterns\\MovieBookingSystem\\src\\main\\java\\org\\example\\resources\\data.db";

    private static final String ACCOUNT_TABLE = """
            CREATE TABLE IF NOT EXISTS Account (
            accountId INTEGER PRIMARY KEY AUTOINCREMENT,
            password VARCHAR(255),
            status VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15)
            );
            """;
    //accountId INT AUTO_INCREMENT,
    //PRIMARY KEY (accountId)

    //I changed this a bit because we have so much repeating stuff  from account
    private static final String PAYMENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Payment (
            paymentId INTEGER PRIMARY KEY AUTOINCREMENT,
            amount DECIMAL(10,2),
            accountId INT,
            FOREIGN KEY (accountId) REFERENCES Account(accountId)
            );
            """;

    //CREATE TABLE IF NOT EXISTS Payment (
    //            paymentId INT AUTO_INCREMENT,
    //            password VARCHAR(255),
    //            status VARCHAR(255),
    //            email VARCHAR(255),
    //            phone VARCHAR(15),
    //            PRIMARY KEY (paymentId)
    //            FOREIGN KEY (accountId)
    //            );

    private static final String CUSTOMER_TABLE = """
            CREATE TABLE IF NOT EXISTS Customer (
            userId INTEGER PRIMARY KEY AUTOINCREMENT,
            name VARCHAR(255),
            address VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            accountId VARCHAR(255),
            FOREIGN KEY (accountId) REFERENCES Account(accountId)
            );
            """;
    ///CUSTOMER TYPE?(like people in wheelchair and stuff)
    //userId INT AUTO_INCREMENT,
    //PRIMARY KEY (userId)
    //            FOREIGN KEY (accountId)

    private static final String BOOKING_TABLE = """
            CREATE TABLE IF NOT EXISTS Booking (
            bookingId INTEGER PRIMARY KEY AUTOINCREMENT,
            userId INT,
            showTimeId INT,
            FOREIGN KEY (userId) REFERENCES Customer(UserId),
            FOREIGN KEY (showTimeId) REFERENCES ShowTimes(showTimeId)
            );
            """;
    //bookingId INT AUTO_INCREMENT,

    private static final String THEATRE_TABLE = """
            CREATE TABLE IF NOT EXISTS Theater (
            theaterID INTEGER PRIMARY KEY AUTOINCREMENT,
            location VARCHAR(255),
            SeatingCapacity INT
            );
            """;
    //SeatingCapacity VARCHAR(255),

    private static final String SHOWTIME_TABLE = """
            CREATE TABLE IF NOT EXISTS ShowTimes (
            ShowtimeID INTEGER PRIMARY KEY AUTOINCREMENT,
            MovieID INT,
            TheaterID INT,
            Showtime DATETIME,
            FOREIGN KEY (MovieID) REFERENCES Movies(MovieID),
            FOREIGN KEY (TheaterID) REFERENCES Theaters(TheaterID)
            );
            """;

    private static final String ADMIN_TABLE = """
            CREATE TABLE IF NOT EXISTS Admin (
            adminID INTEGER PRIMARY KEY AUTOINCREMENT,
            username VARCHAR(255),
            Password VARCHAR(255)
            );
            """;

    private static final String MOVIE_TABLE = """
            CREATE TABLE IF NOT EXISTS Movies (
            MovieID INTEGER PRIMARY KEY AUTOINCREMENT,
            Title VARCHAR(255),
            Genre VARCHAR(255),
            Rating DECIMAL(3,2),
            Duration INT,
            Synopsis TEXT
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
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //Dont remove it we need the executeUpdate and getRecord
    //executeUpdate helps send changes to the database, we use it to safely send the data and handle any errors.
    public int executeUpdate(String sql, Object[] values) {
        int rowsAffected = 0;
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            for(int i = 0; i < values.length; i++) {
                ps.setObject(i+1, values[i]);
            }
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    //this makes sure to get all the data from the database and convert it into a format, so i think we can work with it easily
    public List<Map<String,Object>> getRecords(String sql) {
        List<Map<String, Object>> records = new ArrayList<>();
        try(Connection conn = connect();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for(int i = 1; i <= columnCount; i++) {
                    row.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                records.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void createAllTables() {
        executeSql(ACCOUNT_TABLE);
        executeSql(PAYMENT_TABLE);
        executeSql(CUSTOMER_TABLE);
        executeSql(BOOKING_TABLE);
        executeSql(THEATRE_TABLE);
        executeSql(SHOWTIME_TABLE);
        executeSql(ADMIN_TABLE);
        executeSql(MOVIE_TABLE);
    }

    public static final String INSERT_SQL = """
            INSERT INTO students VALUES(1, "MIKE", 18)
   
    """;
}
