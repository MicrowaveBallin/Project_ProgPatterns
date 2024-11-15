package org.example.controller;

import org.example.model.Booking;
import org.example.model.Client;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookingController extends Controller {
    private Map<Integer, Client> bookings;
    private Scanner sc = new Scanner(System.in);
    private Booking booking;
    private DatabaseUtil db;

    public BookingController(Connection connection) {
        super(connection);
        this.booking = new Booking();
        this.db = new DatabaseUtil();
        bookings = new HashMap<>();
    }


    // Method to handle booking a ticket
    public void bookTicket(int userId) {
        System.out.println("Enter showtimeId for booking:");
        int showTimeId = sc.nextInt();
        System.out.println("Enter seat choice:");
        int seatChoice = sc.nextInt(); // This seat is only used for reference or further validation.

        boolean success = booking.createBooking(userId, showTimeId, seatChoice);

        if (success) {
            System.out.println("Booking successful.");
        } else {
            System.out.println("Booking failed.");
        }
    }

    // Method to view all bookings for a user
    public void seeTicket(int userId) {
        System.out.println("Viewing all bookings for user " + userId);
        booking.getAllBookingsForUser(userId);
    }

    // Method to cancel a booking
    public void cancelTicket(int userId) {
        System.out.println("Enter bookingId to cancel:");
        int bookingId = sc.nextInt();

        boolean success = booking.cancelBooking(bookingId);

        if (success) {
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Cancellation failed.");
        }
    }

    // Method to handle user actions
    public void handleRequest() {
        System.out.println("Choose an action: ");
        System.out.println("1. Book a ticket");
        System.out.println("2. View bookings");
        System.out.println("3. Cancel booking");
        int choice = sc.nextInt();
        int userId;

        switch (choice) {
            case 1:
                System.out.println("Enter your user ID:");
                userId = sc.nextInt();
                bookTicket(userId);
                break;
            case 2:
                System.out.println("Enter your user ID:");
                userId = sc.nextInt();
                seeTicket(userId);
                break;
            case 3:
                System.out.println("Enter your user ID:");
                userId = sc.nextInt();
                cancelTicket(userId);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
