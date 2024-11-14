package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Showing {
    DatabaseUtil db = new DatabaseUtil();
    public void insertShowtime(int MovieID,int TheaterID,Timestamp showtime){
        String sql = "INSERT INTO Showing(movieId,TheaterId,showTime) VALUES(?,?,?)";
        Object[] values = {MovieID,TheaterID,showtime};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Showing added successfully");
        else
            System.out.println("Something went wrong. Showing not inserted.");

    }

    public void displayShowing(){
        String sql = "SELECT * from Showing";
        List<Map<String,Object>> showings = db.getRecords(sql);
        for (Map<String, Object> showing : showings) {
            System.out.println("Showtime ID: " + showing.get("showingId"));
            System.out.println("Movie ID: " + showing.get("movieId"));
            System.out.println("Theater ID: " + showing.get("theaterId"));
            System.out.println("Showtime: " + showing.get("showTime"));
            System.out.println("-----------------------------");
        }
    }

    public void showShowtimesDetails(int showtimeID){
        String sql = "SELECT s.ShowtimeID, m.Title,m.Duration,s.Showtime from Showing s, Movie m where s.MovieID = m.MovieID and s.ShowtimeID = ? ";
        db.getShowtimeDetails(sql, showtimeID);
    }
    public int getTheaterCapacity(int showtime){
        String sql = "SELECT SeatingCapacity from theaters where TheaterID = (SELECT TheaterID from showtimes where ShowtimeID = ?)";
        return db.getSeatingCapacity(sql, showtime);
    }
}