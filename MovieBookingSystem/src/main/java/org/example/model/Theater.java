package org.example.model;

public class Theater {
    private int theaterId;
    private String location;

    // Constructor
    public Theater(int theaterId, String location) {
        this.theaterId = theaterId;
        this.location = location;
    }

    // Getters and Setters
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
