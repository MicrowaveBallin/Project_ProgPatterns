package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public AdminLoginView() {
        setTitle("Admin Login");
        setLayout(new FlowLayout());

        // Initialize components
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");

        // Add components to the layout
        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);

        // Action listener for the "Login" button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the username and password are correct
                if ("admin".equals(username) && "12345678".equals(password)) {
                    new AdminMainView().setVisible(true);  // Redirect to Admin Main View
                    dispose();  // Close the Admin Login view
                } else {
                    JOptionPane.showMessageDialog(AdminLoginView.this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // JFrame settings
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}