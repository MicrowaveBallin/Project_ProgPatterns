package org.example.view;

import org.example.util.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterView extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterView() {
        setTitle("Register");
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        registerButton = new JButton("Register");

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement registration logic here
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (register(name, email, password)) {
                    JOptionPane.showMessageDialog(RegisterView.this, "Registration successful!");
                    new LoginView().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(RegisterView.this, "Registration failed.");
                }
            }
        });

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private boolean register(String name, String email, String password) {
        String insertSql = "INSERT INTO Client (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
            return false;
        }
    }
}