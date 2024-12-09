package org.example;

import org.example.controller.MovieBookingSystemController;
import org.example.util.DatabaseUtil;
import org.example.view.LoginView;
import org.example.view.MainDashboardView;

public class Main {
    public static int loggedClientId;

    public static void main(String[] args) {

        MovieBookingSystemController controller = new MovieBookingSystemController();
        //DatabaseUtil.insertDemoMovies();

        new MainDashboardView().setVisible(true);


    }
}