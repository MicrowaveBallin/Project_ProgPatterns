package org.example;

import org.example.util.DatabaseUtil;
import org.example.view.LoginView;
import org.example.view.MainDashboardView;

public class Main {
    public static void main(String[] args) {
        new MainDashboardView().setVisible(true);

        //DatabaseUtil.createAllTables();
    }
}