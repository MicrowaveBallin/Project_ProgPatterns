package org.example;

import org.example.Enums.AccountStatus;
import org.example.controller.*;
//import org.example.model.Admin;
//import org.example.controller.MovieController;
import org.example.model.*;
import org.example.model.singeton.MovieBookingSystem;
import org.example.util.DatabaseUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MovieBookingSystemController controller = new MovieBookingSystemController();

        Client c1 = new Client("Frank","4","street","bear@pebsi.org","1234567890");
        Client c2 = new Client("Rita","gdjfkf","street","bear@pebsi.org","1234567890");


        controller.addClient(c1);
        controller.addClient(c2);














//        MovieBookingSystem mbs = MovieBookingSystem.getInstance();
//
//        System.out.println(mbs.getClients());
//        System.out.println(mbs.getPayments());



//        //Create tables
//        DatabaseUtil.createAllTables();
//
//        //create controllers
//        ClientController clientController = new ClientController();
//
//        //get clients from database
//        System.out.println("clients");
//        System.out.println(DatabaseUtil.getClients());
//
//        //add a client to the database
//        Client c1 = new Client("Dink", "12345", "125 Pebbles", "pebsi@greatproblem.it","5146900331");
//        clientController.insertClient(c1);
//
//        //print all clients
//        System.out.println(DatabaseUtil.selectFromClient());
//
//        //create a payment
//        System.out.println("payments");
//        c1.addPayment(12.00);

//        //view from client
//        for (Payment payment : c1.getPaymentHistory()) {
//            System.out.println(payment);
//        }
//
//        //view from database
//        for (Payment payment : DatabaseUtil.getAllPayments()) {
//            System.out.println(payment);
//        }


//        MovieController movieController = new MovieController(connection);
//        System.out.println("Movies:");
//
//        // Add a new movie
//        movieController.addMovie("Inception", "Sci-Fi", 8.8, 148, "A mind-bending thriller about dreams within dreams.");
//
//        // Display all movies
//        movieController.displayMovies();

//        try (Connection conn = DatabaseUtil.getConnection()) {
//            // Create controllers
//            AccountController accountController = new AccountController(conn);
//
//            // Create a test client
//            Client testClient = new Client("Test User", "test123", "123 Test St", "test@test.com", "1234567890");
//
//            // Create and insert a test account
//            Account testAccount = new Account(testClient, "password123");
//
//            // Test account insertion
//            boolean inserted = accountController.insertAccount(testAccount);
//            if (inserted) {
//                System.out.println("Test account created with ID: " + testAccount.getAccountId());
//
//                // Test retrieving the account
//                Account retrieved = accountController.getAccountById(testAccount.getAccountId());
//                if (retrieved != null) {
//                    System.out.println("Retrieved account with ID: " + retrieved.getAccountId());
//                    System.out.println("User ID: " + retrieved.getUserId());
//                    System.out.println("Status: " + retrieved.getStatus());
//                }
//
//                // Test updating the account
//                testAccount.setPassword("newpassword123");
//                boolean updated = accountController.updateAccount(testAccount);
//                System.out.println("Account update " + (updated ? "successful" : "failed"));
//
//                // Test deleting the account
//                boolean deleted = accountController.deleteAccount(testAccount.getAccountId());
//                System.out.println("Account deletion " + (deleted ? "successful" : "failed"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Error in main: " + e.getMessage());
//        }
//    }





//        //Booking WORKING OMG
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the BookingController
//        if (connection != null) {
//            BookingController bookingController = new BookingController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Booking System Menu:");
//                System.out.println("1. Book a ticket");
//                System.out.println("2. View bookings");
//                System.out.println("3. Cancel booking");
//                System.out.println("4. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 4) {
//                    break; // Exit the loop
//                }
//
//                bookingController.handleRequest(); // Handle user input based on the action
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (SQLException e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }





        //Cinema Hall (I don't know what is wrong and i have 0 energy to look over it)
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the CinemaHallController
//        if (connection != null) {
//            CinemaHallController cinemaHallController = new CinemaHallController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Cinema Hall System Menu:");
//                System.out.println("1. Add a Cinema Hall");
//                System.out.println("2. View all Cinema Halls");
//                System.out.println("3. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 3) {
//                    break; // Exit the loop
//                }
//
//                switch (choice) {
//                    case 1:
//                        // Adding a Cinema Hall
//                        System.out.println("Enter Cinema Hall ID:");
//                        int cinemaHallId = sc.nextInt();
//                        System.out.println("Enter Theater ID:");
//                        int theaterId = sc.nextInt();
//                        System.out.println("Enter Seating Capacity:");
//                        int seatingCapacity = sc.nextInt();
//
//                        CinemaHall cinemaHall = new CinemaHall(cinemaHallId, theaterId, seatingCapacity);
//                        boolean isInserted = cinemaHallController.insertCinemaHall(cinemaHall);
//                        if (isInserted) {
//                            System.out.println("Cinema Hall added successfully.");
//                        } else {
//                            System.out.println("Failed to add Cinema Hall.");
//                        }
//                        break;
//
//                    case 2:
//                        // Viewing all Cinema Halls
//                        cinemaHallController.getAllCinemaHalls();
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (Exception e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }




        //Movie(i cant even run this cause the movie thing aint working) i give up
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the MovieController
//        if (connection != null) {
//            MovieController movieController = new MovieController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Movie System Menu:");
//                System.out.println("1. Add a Movie");
//                System.out.println("2. View all Movies");
//                System.out.println("3. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 3) {
//                    break; // Exit the loop
//                }
//
//                switch (choice) {
//                    case 1:
//                        // Adding a Movie
//                        System.out.println("Enter Movie Title:");
//                        sc.nextLine(); // Consume the leftover newline
//                        String title = sc.nextLine();
//
//                        System.out.println("Enter the duration of the movie (int Minutes):");
//                        int duration = sc.nextInt();
//
//                        System.out.println("Enter the rating of the movie:");
//                        int rating = sc.nextInt();
//
//                        System.out.println("Enter Movie Genre:");
//                        String genre = sc.nextLine();
//
//                        System.out.println("Enter the synopsis:");
//                        String synopsis = sc.nextLine();
//
//                        // Creating a new Movie object
//                        Movie movie = new Movie(movieId, title, duration, rating, genre, synopsis); //not working
//
//                        boolean isInserted = movieController.insertMovie(movie);
//                        if (isInserted) {
//                            System.out.println("Movie added successfully.");
//                        } else {
//                            System.out.println("Failed to add Movie.");
//                        }
//                        break;
//
//                    case 2:
//                        // Viewing all Movies
//                        movieController.getAllMovies();
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (Exception e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }



        //Payment
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the PaymentController
//        if (connection != null) {
//            PaymentController paymentController = new PaymentController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Payment System Menu:");
//                System.out.println("1. Add a Payment");
//                System.out.println("2. View Payment Details");
//                System.out.println("3. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 3) {
//                    break; // Exit the loop
//                }
//
//                switch (choice) {
//                    case 1:
//                        // Adding a Payment
//                        System.out.println("Enter Payment ID:");
//                        int paymentId = sc.nextInt();
//
//                        System.out.println("Enter Amount:");
//                        BigDecimal amount = sc.nextBigDecimal();
//
//                        System.out.println("Enter Account ID:");
//                        int accountId = sc.nextInt();
//
//                        // Creating a new Payment object
//                        Payment payment = new Payment(paymentId, amount, accountId);
//
//                        boolean isInserted = paymentController.insertPayment(payment);
//                        if (isInserted) {
//                            System.out.println("Payment added successfully.");
//                        } else {
//                            System.out.println("Failed to add Payment.");
//                        }
//                        break;
//
//                    case 2:
//                        // Viewing Payment Details
//                        System.out.println("Enter Booking ID to retrieve payment details:");
//                        int bookingId = sc.nextInt();
//
//                        paymentController.getPaymentDetails(bookingId);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (Exception e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }





        //Showing(working ig)
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the ShowingController
//        if (connection != null) {
//            ShowingController showingController = new ShowingController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Showing System Menu:");
//                System.out.println("1. Add a Showing");
//                System.out.println("2. View Showings for a Movie");
//                System.out.println("3. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 3) {
//                    break; // Exit the loop
//                }
//
//                switch (choice) {
//                    case 1:
//                        // Adding a Showing
//                        System.out.println("Enter Showing ID:");
//                        int showingId = sc.nextInt();
//
//                        System.out.println("Enter Movie ID:");
//                        int movieId = sc.nextInt();
//
//                        System.out.println("Enter Theater ID:");
//                        int theaterId = sc.nextInt();
//
//                        System.out.println("Enter Show Time (YYYY-MM-DD HH:MM:SS):");
//                        String showTimeStr = sc.next();
//                        LocalDateTime showTime = LocalDateTime.parse(showTimeStr);
//
//                        // Creating a new Showing object
//                        Showing showing = new Showing(showingId, movieId, theaterId, showTime);
//
//                        boolean isInserted = showingController.insertShowing(showing);
//                        if (isInserted) {
//                            System.out.println("Showing added successfully.");
//                        } else {
//                            System.out.println("Failed to add Showing.");
//                        }
//                        break;
//
//                    case 2:
//                        // View Showings for a Movie
//                        System.out.println("Enter Movie ID to view showings:");
//                        int movieIdToView = sc.nextInt();
//
//                        showingController.getShowingsForMovie(movieIdToView);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (Exception e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }



        //Theater(idk)
//        Scanner sc = new Scanner(System.in);
//
//        // Assuming DatabaseUtil provides a connection to the database
//        Connection connection = DatabaseUtil.getConnection();
//
//        // If the connection is successful, proceed to use the TheaterController
//        if (connection != null) {
//            TheaterController theaterController = new TheaterController(connection);
//
//            // Menu loop for testing
//            while (true) {
//                System.out.println("Theater System Menu:");
//                System.out.println("1. Add a Theater");
//                System.out.println("2. View All Theaters");
//                System.out.println("3. Exit");
//
//                int choice = sc.nextInt();
//
//                if (choice == 3) {
//                    break; // Exit the loop
//                }
//
//                switch (choice) {
//                    case 1:
//                        // Add a new Theater
//                        System.out.println("Enter Theater ID:");
//                        int theaterId = sc.nextInt();
//
//                        sc.nextLine(); // Consume newline left by nextInt()
//
//                        System.out.println("Enter Theater Name:");
//                        String theaterName = sc.nextLine();
//
//                        System.out.println("Enter Theater Location:");
//                        String location = sc.nextLine();
//
//                        // Creating a new Theater object
//                        Theater theater = new Theater(theaterId, theaterName, location);
//
//                        boolean isInserted = theaterController.insertTheater(theater);
//                        if (isInserted) {
//                            System.out.println("Theater added successfully.");
//                        } else {
//                            System.out.println("Failed to add Theater.");
//                        }
//                        break;
//
//                    case 2:
//                        // View all Theaters
//                        theaterController.getAllTheaters();
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//
//            try {
//                connection.close(); // Close the connection when done
//            } catch (Exception e) {
//                System.out.println("Error closing the connection: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Failed to connect to the database.");
//        }
    }
}



//BURNER CODE


//
//        Showing s = new Showing();
//        LocalDateTime date = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
//        Timestamp showtime = Timestamp.from(date.atZone(ZoneId.systemDefault()).toInstant());
//        s.insertShowTime(1,1,new Timestamp(System.currentTimeMillis()));
//        s.showShowtimes();
//
//        Admin a = new Admin();
//        a.adminMenu();


//        Movie movie = new Movie("Inception", 148, 8.8, "Sci-Fi", "A thief steals secrets through dream-sharing technology.");
//        movie.insertMovie();

//        Movie movie = new Movie();
//        movie.showMovies();


//        DatabaseUtil.connect();
//        DatabaseUtil.createAllTables();

//        Theater t = new Theater();
//        t.insertTheater("IMAX",140);
//        t.showTheaters();

//the date part is not working idk which one to use can you fix it?
//ShowTime s = new ShowTime();
//s.insertShowTime(1,1,new Timestamp(System.currentTimeMillis()));
//s.showShowtimes();
