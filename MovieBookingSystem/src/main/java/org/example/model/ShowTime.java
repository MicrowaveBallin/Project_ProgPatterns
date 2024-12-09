package org.example.model;

public class ShowTime {
    private static int counter = 1;
    private int showTimeId;
    private int movieId;
    private String showDateTime;

    public ShowTime(int showTimeId, int movieId, String showDateTime) {
        counter++;
        this.showTimeId = showTimeId;
        this.movieId = movieId;
        this.showDateTime = showDateTime;
    }

    public ShowTime(int movieId, String showDateTime) {
        this.showTimeId = counter++;
        this.movieId = movieId;
        this.showDateTime = showDateTime;
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

    public String getShowDateTime() {
        return showDateTime;
    }

    public void setShowDateTime(String showDateTime) {
        this.showDateTime = showDateTime;
    }

    @Override
    public String toString() {
        return "ShowTime{" +
                "showTimeId=" + showTimeId +
                ", movieId=" + movieId +
                ", showDateTime='" + showDateTime + '\'' +
                '}';
    }
}
