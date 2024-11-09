package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.util.DatabaseUtil.connect;

public class Movie {
    //instance fields
    private String title;
    private String genre;
    private double rating;
    private int duration;
    private String synopsis;

    private DatabaseUtil db = new DatabaseUtil();

    public Movie(String title, int duration, double rating, String genre, String synopsis) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    //Methods to insert movies into database
    public void insertMovie() {
        String sql = "INSERT INTO Movies(title, genre, rating,duration,synopsis) VALUES(?,?,?,?,?)";
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
            ResultSet rs = db.getRecords(sql);
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
                e.printStackTrace();
            }
        }
}
