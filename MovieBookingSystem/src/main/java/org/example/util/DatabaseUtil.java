package org.example.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
    //private static final String BASE_URL = "jdbc:sqlite:C:\\Users\\santh\\Documents\\GitHub\\Project_ProgPatterns\\MovieBookingSystem\\src\\main\\java\\org\\example\\resources\\data.db";
    private static final String BASE_URL = "jdbc:sqlite:./src/main/resources/database/data.db";

    //IMPORTANT NOTES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //AUTO_INCREMENTS might not work
    //remove admin table???

    //done
    private static final String ACCOUNT_TABLE = """
            CREATE TABLE IF NOT EXISTS Account (
            accountId INTEGER AUTO_INCREMENT,
            userId INT,
            password VARCHAR(255),
            status VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            PRIMARY KEY (accountId),
            FOREIGN KEY (userId) REFERENCES Customer(userId)
            );
            """;
    //accountId INT AUTO_INCREMENT,
    //PRIMARY KEY (accountId)

    //done
    //I changed this a bit because we have so much repeating stuff  from account
    private static final String PAYMENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Payment (
            paymentId INTEGER AUTO_INCREMENT,
            amount DECIMAL(10,2),
            accountId INT,
            PRIMARY KEY (paymentId),
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

    //done
    private static final String CUSTOMER_TABLE = """
            CREATE TABLE IF NOT EXISTS Customer (
            userId INTEGER AUTO_INCREMENT,
            name VARCHAR(255),
            address VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15),
            PRIMARY KEY (userId)
            );
            """;
    ///CUSTOMER TYPE?(like people in wheelchair and stuff) //Why would we need that
    //userId INT AUTO_INCREMENT,
    //PRIMARY KEY (userId)
    //            FOREIGN KEY (accountId)

    //done
    private static final String BOOKING_TABLE = """
            CREATE TABLE IF NOT EXISTS Booking (
            bookingId INTEGER AUTO_INCREMENT,
            userId INT,
            showTimeId INT,
            PRIMARY KEY (bookingId),
            FOREIGN KEY (userId) REFERENCES Customer(UserId),
            FOREIGN KEY (showTimeId) REFERENCES Showing(showTimeId)
            );
            """;
    //bookingId INT AUTO_INCREMENT,

    //done
    private static final String THEATRE_TABLE = """
            CREATE TABLE IF NOT EXISTS Theater (
            theaterId INTEGER AUTO_INCREMENT,
            location VARCHAR(255),
            PRIMARY KEY (theaterId)
            );
            """;
    //SeatingCapacity VARCHAR(255),

    //done
    private static final String CINEMA_HALL_TABLE = """
            CREATE TABLE IF NOT EXISTS CinemaHall (
            cinemaHallId INTEGER AUTO_INCREMENT,
            theaterId INT,
            PRIMARY KEY (cinemaHallId),
            FOREIGN KEY (theaterId) REFERENCES Theater(theaterId)
            );
            """;

    //done
    private static final String SHOWING_TABLE = """
            CREATE TABLE IF NOT EXISTS Showing (
            showingId INTEGER AUTO_INCREMENT,
            movieId INT,
            cinemaHallId INT,
            showTime DATETIME,
            PRIMARY KEY (showingId),
            FOREIGN KEY (movieId) REFERENCES Movie(movieId),
            FOREIGN KEY (cinemaHallId) REFERENCES CinemaHall(cinemaHallId)
            );
            """;

    //remove??
    private static final String ADMIN_TABLE = """
            CREATE TABLE IF NOT EXISTS Admin (
            adminId INTEGER AUTO_INCREMENT,
            username VARCHAR(255),
            password VARCHAR(255),
            PRIMARY KEY (adminId)
            );
            """;

    //done
    private static final String MOVIE_TABLE = """
            CREATE TABLE IF NOT EXISTS Movie (
            movieId INTEGER AUTO_INCREMENT,
            title VARCHAR(255),
            genre VARCHAR(255),
            rating DECIMAL(3,2),
            duration INT,
            synopsis TEXT,
            PRIMARY KEY (movieId)
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

    public static void createAllTables() {
        executeSql(ACCOUNT_TABLE);
        executeSql(PAYMENT_TABLE);
        executeSql(CUSTOMER_TABLE);
        executeSql(BOOKING_TABLE);
        executeSql(THEATRE_TABLE);
        executeSql(CINEMA_HALL_TABLE);
        executeSql(SHOWING_TABLE);
        executeSql(ADMIN_TABLE);
        executeSql(MOVIE_TABLE);
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

    //reads from database and turns into plain text
    public static String selectFromCustomer() {
        String sql = "SELECT * FROM Customer";

        StringBuilder builder = new StringBuilder();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through the result set
            while (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                builder.append(String.format("Customer{ ID: %d, Name: %s, Address: %s, Email: %s, Phone: %s}", id, name, address, email, phone));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return builder.toString();
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



    public static final String INSERT_SQL = """
            INSERT INTO students VALUES(1, "MIKE", 18)
   
    """;
}
