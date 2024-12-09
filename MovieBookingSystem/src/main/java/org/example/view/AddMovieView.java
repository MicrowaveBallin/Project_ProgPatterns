package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import org.example.model.Movie;
import org.example.util.DatabaseUtil;
import org.example.controller.MovieController;

public class AddMovieView extends JFrame {
    private JTextField titleField, genreField, ratingField, durationField;
    private JTextArea synopsisArea;
    private JButton saveButton, backButton;

    public AddMovieView() {
        setTitle("Add Movie");
        setLayout(new FlowLayout());

        // Initialize components
        titleField = new JTextField(20);
        genreField = new JTextField(20);
        ratingField = new JTextField(5);
        durationField = new JTextField(5);
        synopsisArea = new JTextArea(5, 20);
        saveButton = new JButton("Save Movie");
        backButton = new JButton("Back");

        // Add components to the layout
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Genre:"));
        add(genreField);
        add(new JLabel("Rating:"));
        add(ratingField);
        add(new JLabel("Duration (minutes):"));
        add(durationField);
        add(new JLabel("Synopsis:"));
        add(new JScrollPane(synopsisArea));
        add(saveButton);
        add(backButton);

        // Action listener for the "Save Movie" button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String genre = genreField.getText();
                double rating = Double.parseDouble(ratingField.getText());
                int duration = Integer.parseInt(durationField.getText());
                String synopsis = synopsisArea.getText();

                // Save movie to the database
                Movie newMovie = new Movie(title, genre, rating, duration, synopsis);
                MovieController.createMovie(newMovie);
                //saveMovieToDatabase(title, genre, rating, duration, synopsis);

                // Clear the fields after saving the movie
                clearFields();
            }
        });

        // Action listener for the "Back" button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminMainView().setVisible(true);  // Redirect to Admin Main view
                dispose();  // Close the Add Movie view
            }
        });

        // JFrame settings
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Method to save movie to the database
    private void saveMovieToDatabase(String title, String genre, double rating, int duration, String synopsis) {
        String query = "INSERT INTO Movie (title, genre, rating, duration, synopsis) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setDouble(3, rating);
            pstmt.setInt(4, duration);
            pstmt.setString(5, synopsis);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(AddMovieView.this, "Movie added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(AddMovieView.this, "Error saving movie to database", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Clear the input fields (text fields and text area)
    private void clearFields() {
        titleField.setText("");  // Clear the title field
        genreField.setText("");  // Clear the genre field
        ratingField.setText(""); // Clear the rating field
        durationField.setText(""); // Clear the duration field
        synopsisArea.setText(""); // Clear the synopsis area
    }
}