package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminMainView extends JFrame {
    private JButton addMovieButton, addBookingButton;

    public AdminMainView() {
        setTitle("Admin Main View");
        setLayout(new FlowLayout());

        // Initialize the buttons
        addMovieButton = new JButton("Add Movie");
        addBookingButton = new JButton("Add Booking");

        // Add buttons to the layout
        add(addMovieButton);
        add(addBookingButton);

        // Action listener for the "Add Movie" button
        addMovieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMovieView().setVisible(true);  // Redirect to Add Movie view
                dispose();  // Close the Admin Main view
            }
        });

        // Action listener for the "Add Booking" button
        addBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookingView().setVisible(true);  // Redirect to Add Booking view
                dispose();  // Close the Admin Main view
            }
        });

        // JFrame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}