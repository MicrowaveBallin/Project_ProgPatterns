package org.example.model;

import org.example.util.DatabaseUtil;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class Showing {
    private int showingId;
    private int movieId;
    private int theaterId;
    private Timestamp showTime;

    // Constructor
    public Showing(int showingId, int movieId, int theaterId, Timestamp showTime) {
        this.showingId = showingId;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showTime = showTime;
    }

    // Getters and Setters
    public int getShowingId() {
        return showingId;
    }

    public void setShowingId(int showingId) {
        this.showingId = showingId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public Timestamp getShowTime() {
        return showTime;
    }

    public void setShowTime(Timestamp showTime) {
        this.showTime = showTime;
    }
}