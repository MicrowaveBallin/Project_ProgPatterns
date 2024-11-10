package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ShowTime {
    DatabaseUtil db = new DatabaseUtil();

    //showTime aint working idk which one to use for that cause there is no dateTime
    public void insertShowTime(int MovieID, int TheaterID, Timestamp showTime) {
        String sql = "INSERT INTO ShowTimes(MovieID, TheaterID, showtime) VALUES (?,?,?)";
        Object[] values = {MovieID, TheaterID, showTime};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected > 0) {
            System.out.println("Showtime added successfully");
        } else {
            System.out.println("Showtime added failed");
        }
    }

    public void showShowtimes(){
        String sql = "SELECT * FROM ShowTimes";
        List<Map<String,Object>> showtimes = db.getRecords(sql);
        for(Map<String, Object> showtime : showtimes) {
            System.out.println("ShowTime ID: " + showtime.get("ShowtimeID"));
            System.out.println("Movie ID: " + showtime.get("MovieID"));
            System.out.println("Theater ID: " + showtime.get("TheaterID"));
            System.out.println("Showtime: " + showtime.get("Showtime"));
            System.out.println("---------------------------------------------");
        }
    }
}