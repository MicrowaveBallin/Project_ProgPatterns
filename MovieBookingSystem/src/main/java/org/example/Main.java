package org.example;

import org.example.model.Movie;
import org.example.util.DatabaseUtil;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseUtil.connect();
        if (connection != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Database connection failed.");
        }
//        Movie movie = new Movie("Race 3", 120, 4.9, "Action","Its a good movie of racing watch it if you want or dont idc");
//        movie.insertMovie();
//        movie.showMovies();
//        DatabaseUtil.connect();
//        DatabaseUtil.createAllTables();

    }
}