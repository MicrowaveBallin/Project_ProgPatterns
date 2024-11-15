package org.example.model;

public class CinemaHall {
    private int cinemaHallId;
    private int theaterId;
    private int seatCapacity;

    public CinemaHall(int cinemaHallId, int theaterId, int seatCapacity) {
        this.cinemaHallId = cinemaHallId;
        this.theaterId = theaterId;
        this.seatCapacity = seatCapacity;
    }

    // Getters and Setters
    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
