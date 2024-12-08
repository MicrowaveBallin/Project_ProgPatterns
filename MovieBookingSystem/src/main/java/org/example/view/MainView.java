package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame {
    private JButton movieButton, bookingButton, paymentButton;

    public MainView() {
        setTitle("Main Menu");
        setLayout(new FlowLayout());

        // Initialize the buttons
        movieButton = new JButton("Movies");
        bookingButton = new JButton("Booking");
        paymentButton = new JButton("Payment");

        // Add buttons to the layout
        add(movieButton);
        add(bookingButton);
        add(paymentButton);

        // Action listeners for each button
        movieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieView().setVisible(true);  // Open MovieView when "Movies" is clicked
                dispose();  // Close the MainView
            }
        });

        bookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if a movie has been selected (or make sure that movie selection is done before proceeding)
                // Open the BookingView with a movie title (which should be set somewhere)
                new BookingView("SomeMovie").setVisible(true);  // This should be updated to reflect the selected movie
                dispose();  // Close the MainView
            }
        });

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PaymentView(0.00).setVisible(true);  // Open PaymentView with a dummy amount for now
                dispose();  // Close the MainView
            }
        });

        // JFrame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);  // Show the MainView
            }
        });
    }
}