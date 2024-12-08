package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainDashboardView extends JFrame {
    private JButton userButton, adminButton;

    public MainDashboardView() {
        setTitle("Main Dashboard");
        setLayout(new FlowLayout());

        // Initialize the buttons
        userButton = new JButton("User");
        adminButton = new JButton("Admin");

        // Add buttons to the layout
        add(userButton);
        add(adminButton);

        // Action listener for the "User" button
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true);  // Redirect to Login page
                dispose();  // Close the Main Dashboard
            }
        });

        // Action listener for the "Admin" button
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLoginView().setVisible(true);  // Redirect to Admin Login page
                dispose();  // Close the Main Dashboard
            }
        });

        // JFrame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainDashboardView().setVisible(true);  // Show the Main Dashboard
            }
        });
    }
}