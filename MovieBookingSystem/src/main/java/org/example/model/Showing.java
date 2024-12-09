package org.example.model;

import java.time.LocalDateTime;

public class Showing {
    private static int counter = 1;
    private int showTimeId;
    private int movieId;
    private LocalDateTime showDateTime;
    private int hallNumber;

    public Showing(int showTimeId, int movieId, LocalDateTime showDateTime, int hallNumber) {
        counter++;
        this.showTimeId = showTimeId;
        this.movieId = movieId;
        this.showDateTime = showDateTime;
        this.hallNumber = hallNumber;
    }

    public Showing(int movieId, LocalDateTime showDateTime, int hallNumber) {
        this.showTimeId = counter++;
        this.movieId = movieId;
        this.showDateTime = showDateTime;
        this.hallNumber = hallNumber;
    }

    // Getters and Setters
    public int getShowTimeId() {
        return showTimeId;
    }
    public void setShowTimeId(int showTimeId) {
        this.showTimeId = showTimeId;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public LocalDateTime getShowDateTime() {
        return showDateTime;
    }
    public void setShowDateTime(LocalDateTime showDateTime) {
        this.showDateTime = showDateTime;
    }

    public int getHallNumber() {
        return hallNumber;
    }
    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
}
