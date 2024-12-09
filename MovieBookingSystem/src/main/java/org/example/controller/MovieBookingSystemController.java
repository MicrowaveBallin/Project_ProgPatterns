package org.example.controller;

import org.example.model.Client;
import org.example.model.Payment;
import org.example.model.singleton.MovieBookingSystem;
import org.example.util.DatabaseUtil;

import java.util.List;
import java.util.stream.Collectors;

public class MovieBookingSystemController {
    private MovieBookingSystem movieBookingSystem;

    public MovieBookingSystemController() {
        DatabaseUtil.createAllTables();
        this.movieBookingSystem = MovieBookingSystem.getInstance();
    }

    public Client findClientById(int id) {
        return movieBookingSystem.getClients().stream()
                .filter(client -> client.getUserId() == id)
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
