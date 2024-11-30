package org.example.controller;

import org.example.model.Client;
import org.example.model.Movie;
import org.example.model.Payment;
import org.example.model.singeton.MovieBookingSystem;

public class MovieBookingSystemController {
    private MovieBookingSystem movieBookingSystem;


    public MovieBookingSystemController() {
        this.movieBookingSystem = MovieBookingSystem.getInstance();
    }

    public void addClient(Client client) {
        movieBookingSystem.addClient(client);
        DatabaseController.insertClient(client);
    }

    public void addPayment(int clientId, double amount) {
        Payment payment = new Payment(clientId, amount);
        movieBookingSystem.addPayment(payment);
        DatabaseController.insertPayment(payment);
    }

    public void addMovie(Movie movie) {

    }






}
