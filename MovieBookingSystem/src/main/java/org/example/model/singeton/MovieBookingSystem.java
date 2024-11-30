package org.example.model.singeton;

import org.example.model.Client;
import org.example.model.Movie;
import org.example.model.Payment;
import org.example.model.User;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class MovieBookingSystem {
    private List<Client> clients;
    private List<Payment> payments;
    private List<Movie> movies;

    private static MovieBookingSystem instance;

    private MovieBookingSystem() {
        clients = DatabaseUtil.getClients();
        payments = DatabaseUtil.getAllPayments();
    }

    public static MovieBookingSystem getInstance() {
        if (instance == null) {
            synchronized (MovieBookingSystem.class) {
                if (instance == null) {
                    instance = new MovieBookingSystem();
                }
            }
        }
        return instance;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }


    public List<Client> getClients() {
        return clients;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Movie> getMovies() {
        return movies;
    }







}
