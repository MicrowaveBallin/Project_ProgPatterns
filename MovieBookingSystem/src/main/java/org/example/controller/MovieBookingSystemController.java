package org.example.controller;

import org.example.model.Client;
import org.example.model.Movie;
import org.example.model.Payment;
import org.example.model.singeton.MovieBookingSystem;
import org.example.util.DatabaseUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MovieBookingSystemController {
    private MovieBookingSystem movieBookingSystem;


    public MovieBookingSystemController() {
        DatabaseUtil.createAllTables();
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


    // lambda stream
    public Client findClientById(int id) {
        return movieBookingSystem.getClients().stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Client> findClientsByName(String search) {
        return movieBookingSystem.getClients().stream()
                .filter(client -> client.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }



    // Getters

    public List<Client> getClients() {
        return movieBookingSystem.getClients();
    }

    public List<Payment> getPayments() {
        return movieBookingSystem.getPayments();
    }






}
