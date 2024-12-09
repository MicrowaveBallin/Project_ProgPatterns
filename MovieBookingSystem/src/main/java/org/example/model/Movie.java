package org.example.model;

public class Movie {
    private static int counter = 1;
    private int movieId;
    private String title;
    private String genre;
    private double rating;
    private int duration;
    private String synopsis;

    public Movie(int movieId, String title, String genre, double rating, int duration, String synopsis) {
        counter++;
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public Movie(String title, String genre, double rating, int duration, String synopsis) {
        this.movieId = counter++;;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    // Getters and Setters
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}