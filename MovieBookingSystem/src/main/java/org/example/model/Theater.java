package org.example.model;

public class Theater {
    private int theaterId;
    private String theaterName;
    private String location;

    // Constructor
    public Theater(int theaterId,String theaterName, String location) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.location = location;
    }

    // Getters and Setters
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
