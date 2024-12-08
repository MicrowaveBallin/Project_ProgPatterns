package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import org.example.util.DatabaseUtil;

public class MovieView extends JFrame {
    private JComboBox<String> movieComboBox;
    private JButton selectButton, goToBookingButton;
    private JTextArea movieDetailsArea;

    public MovieView() {
        setTitle("Select Movie");
        setLayout(new FlowLayout());

        // Initialize components
        movieComboBox = new JComboBox<>();
        selectButton = new JButton("Select Movie");
        goToBookingButton = new JButton("Go to Booking View");
        movieDetailsArea = new JTextArea(6, 30);
        movieDetailsArea.setEditable(false);  // To prevent editing the details

        // Initially disable the "Go to Booking View" button
        goToBookingButton.setEnabled(false);

        // Fetch movies from the database and populate the combo box
        populateMovies();

        // Add components to the layout
        add(new JLabel("Select Movie:"));
        add(movieComboBox);
        add(selectButton);
        add(new JScrollPane(movieDetailsArea));
        add(goToBookingButton);

        // Action when the "Select Movie" button is pressed
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                if (selectedMovie != null && !selectedMovie.equals("Select a movie...")) {
                    // Display the movie details
                    displayMovieDetails(selectedMovie);
                    // Enable the Go to Booking button
                    goToBookingButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(MovieView.this, "Please select a movie", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action when the "Go to Booking View" button is pressed
        goToBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMovie = (String) movieComboBox.getSelectedItem();
                new BookingView(selectedMovie).setVisible(true);  // Pass selected movie to BookingView
                dispose();  // Close the MovieView
            }
        });

        // JFrame settings
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Method to populate movie titles from the database into the combo box
    private void populateMovies() {
        String query = "SELECT movieId, title FROM Movie";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            movieComboBox.addItem("Select a movie..."); // Add a default selection

            // Add each movie title to the combo box
            while (rs.next()) {
                String title = rs.getString("title");
                movieComboBox.addItem(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display the movie details in the text area
    private void displayMovieDetails(String title) {
        String query = "SELECT title, genre, rating, duration, synopsis FROM Movie WHERE title = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String movieDetails = "Title: " + rs.getString("title") + "\n" +
                        "Genre: " + rs.getString("genre") + "\n" +
                        "Rating: " + rs.getDouble("rating") + "\n" +
                        "Duration: " + rs.getInt("duration") + " minutes\n" +
                        "Synopsis: " + rs.getString("synopsis");
                movieDetailsArea.setText(movieDetails);
            } else {
                JOptionPane.showMessageDialog(MovieView.this, "Movie details not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the MovieView
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MovieView().setVisible(true);
            }
        });
    }
}