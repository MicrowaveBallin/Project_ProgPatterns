package org.example;

import org.example.model.Movie;
import org.example.model.ShowTime;
import org.example.model.Theater;
import org.example.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Timestamp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Connection connection = DatabaseUtil.connect();
//        if (connection != null) {
//            System.out.println("Database connection successful!");
//        } else {
//            System.out.println("Database connection failed.");
//        }


//        DatabaseUtil.createAllTables();
//        Movie movie = new Movie("Inception", 148, 8.8, "Sci-Fi", "A thief steals secrets through dream-sharing technology.");
//        movie.insertMovie();

//        Movie movie = new Movie();
//        movie.showMovies();


//        DatabaseUtil.connect();
//        DatabaseUtil.createAllTables();

//        Theater t = new Theater();
//        t.insertTheater("IMAX",140);
//        t.showTheaters();

        //the date part is not working idk which one to use can you fix it?
        ShowTime s = new ShowTime();
        s.insertShowTime(1,1,new Timestamp(System.currentTimeMillis()));
        s.showShowtimes();

    }
}