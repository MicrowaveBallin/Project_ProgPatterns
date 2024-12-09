package org.example.model.singleton;

import org.example.model.*;
import org.example.util.DatabaseUtil;

import java.util.List;

public class MovieBookingSystem {
    private List<Client> clients;
    private List<Payment> payments;
    private List<Movie> movies;
    private List<ShowTime> showTimes;
    private List<Booking> bookings;
    private static MovieBookingSystem instance;

    private MovieBookingSystem() {
        clients = DatabaseUtil.getClients();
        payments = DatabaseUtil.getAllPayments();
        movies = DatabaseUtil.getAllMovies();
        showTimes = DatabaseUtil.getAllShowTimes();
        bookings = DatabaseUtil.getAllBookings();
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

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addShowTime(ShowTime showTime) {
        showTimes.add(showTime);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public static int getMovieIdByName(String movieName) {
        return DatabaseUtil.getAllMovies().stream()
                .filter(movie -> movie.getTitle().equals(movieName))
                .findFirst()
                .map(Movie::getMovieId)
                .orElseThrow(() -> new IllegalArgumentException("No movie found with name: " + movieName));
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

    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    public List<Booking> getBookings() {
        return bookings;
    }


}
