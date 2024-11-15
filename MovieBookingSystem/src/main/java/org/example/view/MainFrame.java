package org.example.view;

import javax.swing.*;
import java.awt.*;
import org.example.controller.ClientController;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CustomerView customerView;

    public MainFrame() {
        // Set basic properties for the frame
        setTitle("Movie Ticket Booking System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        // Initialize CustomerView
        customerView = new CustomerView();
        mainPanel.add(customerView, "CustomerView");

        // Add a navigation button to switch between views (example)
        JButton showCustomerViewButton = new JButton("Show Customer Info");
        showCustomerViewButton.addActionListener(e -> showCustomerView());

        // Main frame layout
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(showCustomerViewButton, BorderLayout.SOUTH);
    }

    // Method to show the CustomerView
    private void showCustomerView() {
        CardLayout cl = (CardLayout) (mainPanel.getLayout());
        cl.show(mainPanel, "CustomerView");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
