package org.example.util;

import org.example.model.*;
import org.example.model.factory.DatabaseObjectFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
    private static final String BASE_URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    private static final Connection connection = DatabaseUtil.connect();

    //IMPORTANT NOTES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //put all READING function in Controller classes here and make them static
    //remove admin table???maybe lets see at the end but not now

    //======================= TABLES =========================
//    //done
//    private static final String ACCOUNT_TABLE = """
//            CREATE TABLE IF NOT EXISTS Account (
//            accountId INTEGER PRIMARY KEY AUTOINCREMENT,
//            userId INT,
//            password VARCHAR(255),
//            status VARCHAR(255),
//            FOREIGN KEY (userId) REFERENCES Client(userId)
//            );
//            """;


    //done
    //model class done
    private static final String CLIENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Client (
            userId INTEGER PRIMARY KEY AUTOINCREMENT,
            name VARCHAR(255),
            password VARCHAR(255),
            address VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(15)
            );
            """;

    //done
    //model class done
    private static final String PAYMENT_TABLE = """
            CREATE TABLE IF NOT EXISTS Payment (
            paymentId INTEGER PRIMARY KEY AUTOINCREMENT,
            userId INT,
            amount DECIMAL(10,2),
            FOREIGN KEY (userId) REFERENCES Client(userId)
            );
            """;

    //done
    //model and controller class done
    private static final String BOOKING_TABLE = """
            CREATE TABLE IF NOT EXISTS Booking (
            bookingId INTEGER PRIMARY KEY AUTOINCREMENT,
            userId INT,
            showTimeId INT,
            FOREIGN KEY (userId) REFERENCES Client(UserId),
            FOREIGN KEY (showTimeId) REFERENCES Showing(showTimeId)
            );
            """;

    //done
    //model and controller done but still gotta fix when we do JFrame
    private static final String THEATRE_TABLE = """
            CREATE TABLE IF NOT EXISTS Theater (
            theaterId INTEGER PRIMARY KEY AUTOINCREMENT,
            theaterName VARCHAR(255),
            location VARCHAR(255)
            );
            """;
    //SeatingCapacity VARCHAR(255),

    //done
    private static final String CINEMA_HALL_TABLE = """
            CREATE TABLE IF NOT EXISTS CinemaHall (
            cinemaHallId INTEGER PRIMARY KEY AUTOINCREMENT,
            theaterId INT,
            SeatCapacity INT,
            FOREIGN KEY (theaterId) REFERENCES Theater(theaterId)
            );
            """;

    //done
    //model and controller class done
    private static final String SHOWING_TABLE = """
            CREATE TABLE IF NOT EXISTS Showing (
            showingId INTEGER PRIMARY KEY AUTOINCREMENT,
            movieId INT,
            cinemaHallId INT,
            showTime DATETIME,
            FOREIGN KEY (movieId) REFERENCES Movie(movieId),
            FOREIGN KEY (cinemaHallId) REFERENCES CinemaHall(cinemaHallId)
            );
            """;

    //remove??
    private static final String ADMIN_TABLE = """
            CREATE TABLE IF NOT EXISTS Admin (
            adminId INTEGER PRIMARY KEY AUTOINCREMENT,
            username VARCHAR(255),
            password VARCHAR(255)
            );
            """;

    //done
    //model and controller done
    private static final String MOVIE_TABLE = """
            CREATE TABLE IF NOT EXISTS Movie (
            movieId INTEGER PRIMARY KEY AUTOINCREMENT,
            title VARCHAR(255) NOT NULL,
            genre VARCHAR(255),
            rating DECIMAL(3,2),
            duration INT,
            synopsis VARCHAR(255)
            );
            """;

    //=============================== GENERAL =================================

    public static Connection getConnection() {
//        if (connection == null) {
//            connection = connect();
//        }
        return connection;
    }

    private static Connection connect() {
        try {
            return DriverManager.getConnection(BASE_URL);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void createAllTables() {
        //executeSql(ACCOUNT_TABLE);
        executeSql(CLIENT_TABLE);
        executeSql(PAYMENT_TABLE);
        executeSql(BOOKING_TABLE);
        executeSql(THEATRE_TABLE); //error
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

    public static int executeUpdate(String sql, Object[] values) {
        int rowsAffected = 0;
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            for(int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }
        } catch(SQLException e) {
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



    // =============================================== TABLE/CLASS SPECIFIC ==================================

    //CLIENT

    public static Map<Integer, Client> getClients() {
        Map<Integer, Client> clients = new HashMap<>();
        String sql = "SELECT * FROM Client";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client client = DatabaseObjectFactory.createClient(rs);
                clients.put(client.getId(), client);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching clients: " + e.getMessage());
        }
        return clients;
    }



    //PAYMENT
    public static List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment payment = DatabaseObjectFactory.createPayment(rs);
                payments.add(payment.getPaymentId(), payment);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching payments: " + e.getMessage());
        }
        return payments;
    }

    public static Map<Integer, Payment> getPayments(int clientId) {
        Map<Integer, Payment> payments = new HashMap<>();
        String sql = "SELECT * FROM Payment WHERE userId = " + clientId;
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Payment payment = DatabaseObjectFactory.createPayment(rs);
                payments.put(payment.getPaymentId(), payment);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching payments: " + e.getMessage());
        }
        return payments;
    }

    // Method to insert a new payment
    public static boolean insertPayment(Payment payment) {
        String sql = "INSERT INTO Payment (paymentId, userId, amount) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getPaymentId());
            pstmt.setInt(2, payment.getClientId());
            pstmt.setDouble(3, payment.getAmount());
            pstmt.executeUpdate();
            System.out.println("Payment inserted successfully.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    //BOOKING
    private static List<Booking> getBookingsForClient(Connection conn, int clientId) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE clientId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bookings.add(DatabaseObjectFactory.createBooking(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching bookings: " + e.getMessage());
        }
        return bookings;
    }

    //SHOWING
    private static List<Showing> getShowingsForMovie(Connection conn, int movieId) {
        List<Showing> showings = new ArrayList<>();
        String sql = "SELECT * FROM Showing WHERE movieId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, movieId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                showings.add(DatabaseObjectFactory.createShowing(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching showings: " + e.getMessage());
        }
        return showings;
    }

    //THEATER
    private static List<Theater> getTheatersForCinema(Connection conn, int cinemaId) {
        List<Theater> theaters = new ArrayList<>();
        String sql = "SELECT * FROM Theater WHERE cinemaId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cinemaId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                theaters.add(DatabaseObjectFactory.createTheater(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching theaters: " + e.getMessage());
        }
        return theaters;
    }


    //CINEMAHALL
    private static List<CinemaHall> getCinemaHallsForTheater(Connection conn, int theaterId) {
        List<CinemaHall> cinemaHalls = new ArrayList<>();
        String sql = "SELECT * FROM CinemaHall WHERE theaterId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, theaterId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cinemaHalls.add(DatabaseObjectFactory.createCinemaHall(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching cinema halls: " + e.getMessage());
        }
        return cinemaHalls;
    }



    //Nick finsih work here <-----------------------------------------------------------
//
//    public static List<Payment> getPayments(Connection conn,) {
//        List<Payment> payments = new ArrayList<>();
//        String sql = "SELECT * FROM Payments WHERE paymentId = " + ;
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Client client = DatabaseObjectFactory.createClient(rs);
//                clients.put(client.getId(), client);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error fetching clients: " + e.getMessage());
//        }
//        return clients;
//    }



    //reads from database and turns into plain text
    public static String selectFromClient() {
        String sql = "SELECT * FROM Client";

        StringBuilder builder = new StringBuilder();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through the result set
            while (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                builder.append(String.format("Client{ ID: %d, Name: %s, Password: %s, Address: %s, Email: %s, Phone: %s}\n", id, name, password,address, email, phone));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return builder.toString();
    }

    public static final String INSERT_SQL = """
            INSERT INTO students VALUES(1, "MIKE", 18)
    """;

    public int getSeatingCapacity(String sql, int parameter){
        int record = 0;
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,parameter);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                record = rs.getInt("SeatCapacity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    public ArrayList<Integer> getBookedSeats(int showtimeID){
        String sql = "SELECT selectedSeats from bookings where showtimeID = ?";
        ArrayList<Integer> bookedSeats = new ArrayList<>();
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,showtimeID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bookedSeats.add(rs.getInt("SelectedSeats"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookedSeats;
    }


    public ArrayList<Integer> getShowtimeDetailsForUser(int userID,int showtimeID){
        String sql = "SELECT SelectedSeats from bookings where ShowtimeID = ?";
        ArrayList<Integer> bookedSeats = new ArrayList<>();

        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, showtimeID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bookedSeats.add(rs.getInt("SelectedSeats"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookedSeats;
    }

    public void getAllBookingsForUser(int userID){
        String sql = "SELECT * from bookings where userid =?";
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("----- Booking Details -----");
                System.out.println("Booking ID: "+rs.getInt("BookingID"));
                System.out.println("Showtime ID: "+rs.getInt("ShowtimeID"));
                System.out.println("Seat number: "+rs.getInt("SelectedSeats"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getShowtimeDetails(String sql,int showingId){
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, showingId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int showtimeID_sql = rs.getInt("ShowtimeID");
                String title = rs.getString("Title");
                int duration = rs.getInt("Duration");
                Time showtime = rs.getTime("Showtime");
                System.out.println("ShowtimeID: " + showtimeID_sql + ", Title: " + title + ", Duration: " + duration + ", Showtime: " + showtime);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public int removeBooking(int bookingID){
        //enter any booking id and works
        //future scope : to verify if booking is users or not
        String sql = "DELETE from bookings where BookingID =?";
        int rowsAffected = 0;
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, bookingID);
            rowsAffected = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public String validatePass(String sql,String username){
        String pass = "";
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                pass = rs.getString("password");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return pass;
    }

    public int fetchUserID(String sql , String username){
        int userID = 0;
        try(Connection conn = connect();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                userID = rs.getInt("UserID");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return userID;
    }

    public List<Map<String,Object>> getRecordsShowing(String sql, int showtimeId) {
        List<Map<String, Object>> records = new ArrayList<>();
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, showtimeId);  // Set the showtimeId parameter
            ResultSet rs = ps.executeQuery();

            // Check if any results are returned
            if (!rs.next()) {
                System.out.println("No records found for Showtime ID: " + showtimeId);
                return records; // Return empty list if no results
            }

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // Print column names for debugging
            System.out.println("Column Count: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
            }

            // Process the result set
            do {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                records.add(row);
            } while (rs.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}


//
//
////ACCOUNT
////move to util
//public static Map<Integer, Account> getAccount(Connection connection) {
//    Map<Integer, Account> accounts = new HashMap<>();
//    String sql = "SELECT * FROM Account";
//    try (Statement stmt = connection.createStatement();
//         ResultSet rs = stmt.executeQuery(sql)) {
//        while (rs.next()) {
//            Account account = DatabaseObjectFactory.createAccount(rs);
//            accounts.put(account.getId(), account);
//        }
//    } catch (SQLException e) {
//        System.out.println("Error fetching clients: " + e.getMessage());
//    }
//    return accounts;
//}





//Dont remove it we need the executeUpdate and getRecord
//executeUpdate helps send changes to the database, we use it to safely send the data and handle any errors.
    /*public int executeUpdate(String sql, Object[] values) {
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
    }*/

//    //ACCOUNT
//
//    public static Map<Integer, Account> getAccounts(Connection conn) {
//        Map<Integer, Account> accounts = new HashMap<>();
//        String sql = "SELECT * FROM Account";
//        try (Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//            while (rs.next()) {
//                Account account = DatabaseObjectFactory.createAccount(rs);
//                accounts.put(account.getAccountId(), account);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error fetching accounts: " + e.getMessage());
//        }
//        return accounts;
//    }
