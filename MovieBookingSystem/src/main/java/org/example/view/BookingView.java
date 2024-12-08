package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingView extends JFrame {
    private JComboBox<String> showtimeComboBox;
    private JButton bookButton, payNowButton;
    private String selectedMovie;
    private double amountToPay;

    public BookingView(String movieTitle) {
        selectedMovie = movieTitle;  // Get the selected movie title
        setTitle("Select Showtime for " + selectedMovie);
        setLayout(new FlowLayout());

        // Initialize the showtime options in the ComboBox
        showtimeComboBox = new JComboBox<>(new String[] {"10:00 AM", "2:00 PM", "6:00 PM"});
        bookButton = new JButton("Book Now");
        payNowButton = new JButton("Pay Now");
        payNowButton.setEnabled(false);  // Initially disable the Pay Now button

        // Add components to the JFrame
        add(new JLabel("Select Showtime:"));
        add(showtimeComboBox);
        add(bookButton);
        add(payNowButton);

        // Action listener for the "Book Now" button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShowtime = (String) showtimeComboBox.getSelectedItem();
                // Calculate the amount based on the selected showtime
                calculateAmount(selectedShowtime);

                // Enable the "Pay Now" button after booking
                payNowButton.setEnabled(true);
            }
        });

        // Action listener for the "Pay Now" button
        payNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaymentView(amountToPay).setVisible(true);  // Open PaymentView with calculated amount
                dispose();  // Close the BookingView
            }
        });

        // JFrame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Method to calculate the amount to be paid based on the showtime selection
    private void calculateAmount(String showtime) {
        switch (showtime) {
            case "10:00 AM":
                amountToPay = 10.00;  // Example price for this showtime
                break;
            case "2:00 PM":
                amountToPay = 12.00;  // Example price for this showtime
                break;
            case "6:00 PM":
                amountToPay = 15.00;  // Example price for this showtime
                break;
            default:
                amountToPay = 0.00;
                break;
        }
    }
}