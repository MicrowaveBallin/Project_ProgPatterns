package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.controller.DatabaseController;
import org.example.controller.ShowTimeController;
import org.example.model.ShowTime;
import org.example.util.DatabaseUtil;

public class AddBookingView extends JFrame {
    private JComboBox<String> movieComboBox;
    private JTextField showtimeField;
    private JButton addButton, removeButton, backButton;

    public AddBookingView() {
        setTitle("Add Booking");
        setLayout(new FlowLayout());

        // Initialize components
        movieComboBox = new JComboBox<>();
        showtimeField = new JTextField(10);
        addButton = new JButton("Add Showtime");
        removeButton = new JButton("Remove Showtime");
        backButton = new JButton("Back");

        // Add components to the layout
        add(new JLabel("Select Movie:"));
        add(movieComboBox);
        add(new JLabel("Showtime:"));
        add(showtimeField);
        add(addButton);
        add(removeButton);
        add(backButton);

        // Load movie titles into the combo box
        loadMovies();

        // Action listener for the "Add Showtime" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                String showDateTime = showtimeField.getText();

                // Get movieId from movie title
                int movieId = getMovieIdFromTitle(selectedMovie);

                // Create object
                ShowTime showTime = new ShowTime(movieId, showDateTime);

                // Delegate action to ShowTimeController
                boolean success = ShowTimeController.addShowtime(showTime);

                if (success) {
                    JOptionPane.showMessageDialog(AddBookingView.this, "Showtime added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(AddBookingView.this, "Error adding showtime", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Clear the fields after adding the showtime
                clearFields();
            }
        });

        // Action listener for the "Remove Showtime" button FIXX
//        removeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedMovie = (String) movieComboBox.getSelectedItem();
//                String showDateTime = showtimeField.getText();
//
//                // Create object FIXX
//                ShowTime showTime = new ShowTime(selectedMovie,showDateTime);
//
//                // Delegate action to ShowTimeController
//                boolean success = ShowTimeController.removeShowtime(showTime);
//
//                if (success) {
//                    JOptionPane.showMessageDialog(AddBookingView.this, "Showtime removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    JOptionPane.showMessageDialog(AddBookingView.this, "Error removing showtime", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//
//                // Clear the fields after removing the showtime
//                clearFields();
//            }
//        });



        // Action listener for the "Back" button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminMainView().setVisible(true);  // Redirect to Admin Main view
                dispose();  // Close the Add Booking view
            }
        });

        // JFrame settings
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    //FIXX
//    private int getMovieIdByName(String movieName) {
//        return DatabaseController.get.stream()
//                .filter(movie -> movie.getName().equals(movieName))
//                .findFirst()
//                .map(Movie::getId)
//                .orElseThrow(() -> new IllegalArgumentException("No movie found with name: " + movieName));
//    }

    // Load movie titles into combo box
    private void loadMovies() {
        String query = "SELECT title FROM Movie";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                movieComboBox.addItem(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get movieId from the movie title
    private int getMovieIdFromTitle(String movieTitle) {
        String query = "SELECT movieId FROM Movie WHERE title = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, movieTitle);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("movieId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if no movieId is found
    }

    // Clear the input fields (combo box and text field)
    private void clearFields() {
        movieComboBox.setSelectedIndex(0);  // Reset combo box to the first item (default movie)
        showtimeField.setText("");  // Clear the showtime field
    }


}