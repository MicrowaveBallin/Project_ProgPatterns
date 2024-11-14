package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.example.util.DatabaseUtil.connect;

public class Movie {
    //instance fields
    private String title;
    private String genre;
    private double rating;
    private int duration;
    private String synopsis;

    private DatabaseUtil db = new DatabaseUtil();


    //Methods to insert movies into database
    public void insertMovie(String title, String genre, double rating, int duration, String synopsis) {
        String sql = "INSERT INTO Movies(title, genre, rating, duration, synopsis) VALUES(?,?,?,?,?)";
        Object[] values = {title, genre, rating, duration, synopsis};
        int rowAffected = db.executeUpdate(sql, values);
        if (rowAffected > 0) {
            System.out.println("Movie inserted successfully");
        } else {
            System.out.println("Movie not inserted successfully");
        }
    }



        //methods to view all movies in database
        public void showMovies() {
            String sql = "SELECT * FROM Movies";
            List<Map<String, Object>> movies = db.getRecords(sql);
            for(Map<String, Object> movie : movies){
                System.out.println("Movie ID: " + movie.get("MovieID"));
                System.out.println("Title: " + movie.get("Title"));
                System.out.println("Genre: " + movie.get("Genre"));
                System.out.println("Rating: " + movie.get("Rating"));
                System.out.println("Duration (in mins): " + movie.get("Duration"));
                System.out.println("Synopsis: " + movie.get("Synopsis"));
                System.out.println("---------------------------------------------------");
            }
        }

/*ResultSet rs = db.getRecords(sql);
            try {
                    while (rs != null && rs.next()) {
        System.out.println("Movie ID: " + rs.getInt("MovieID"));
        System.out.println("Title: " + rs.getString("Title"));
        System.out.println("Genre: " + rs.getString("Genre"));
        System.out.println("Rating: " + rs.getString("Rating"));
        System.out.println("Duration (in mins): " + rs.getString("Duration"));
        System.out.println("Synopsis: " + rs.getString("Synopsis"));
        System.out.println("---------------------------------------------------");
                }
                        } catch (SQLException e) {
        e.printStackTrace();*/

}


/*package org.example.model;

import org.example.util.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movie {
    private String title;
    private String genre;
    private double rating;
    private int duration;
    private String synopsis;

//    public Movie(){
//
//    }

    public Movie(String title, int duration, double rating, String genre, String synopsis) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    // Method to insert a movie into the Movies table in the database
    public void insertMovie() {
        String sql = "INSERT INTO Movies (title, genre, rating, duration, synopsis) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtil.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Set the movie details into the statement placeholders
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setDouble(3, rating);
            pstmt.setInt(4, duration);
            pstmt.setString(5, synopsis);

            // Execute the insert and check if rows were affected
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Movie inserted successfully");
            } else {
                System.out.println("Movie not inserted successfully");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting movie: " + e.getMessage());
        }
    }

    // Method to retrieve and display all movies from the Movies table
    public void showMovies() {
        String sql = "SELECT * FROM Movies";
        try (Connection connection = DatabaseUtil.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Loop through the result set and print each movie's details
            while (rs.next()) {
                System.out.println("Movie ID: " + rs.getInt("MovieID"));
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Genre: " + rs.getString("Genre"));
                System.out.println("Rating: " + rs.getDouble("Rating"));
                System.out.println("Duration (in mins): " + rs.getInt("Duration"));
                System.out.println("Synopsis: " + rs.getString("Synopsis"));
                System.out.println("---------------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving movies: " + e.getMessage());
        }
    }
}*/