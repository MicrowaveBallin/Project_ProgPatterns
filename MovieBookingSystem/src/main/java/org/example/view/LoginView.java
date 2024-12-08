package org.example.view;

import org.example.util.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginView extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginView() {
        setTitle("Login");
        setLayout(new FlowLayout());

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement login logic here
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (login(email, password)) {
                    new MainView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Invalid login credentials");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the register view
                new RegisterView().setVisible(true);
                dispose();
            }
        });

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private boolean login(String email, String password) {
        String query = "SELECT * FROM Client WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // If a row is returned, login is successful
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
    }
}