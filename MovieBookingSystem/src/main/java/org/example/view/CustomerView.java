package org.example.view;

import org.example.controller.ClientController;
import org.example.model.Client;

import javax.swing.*;

public class CustomerView extends JPanel {
    private JLabel nameLabel, emailLabel, phoneLabel, addressLabel;;
    private JTextField nameField, emailField, phoneField;
    private JButton fetchCustomerButton, updateCustomerButton;
    private ClientController customerController;

    public CustomerView() {
        //customerController = new ClientController();

        // Layout setup
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Initialize components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(15);

        addressLabel = new JLabel("Address:");
        addressLabel = new JLabel("City:");

        fetchCustomerButton = new JButton("Fetch Customer Info");
        updateCustomerButton = new JButton("Update Customer Info");

        // Add components to the panel
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(phoneLabel);
        add(phoneField);
        add(fetchCustomerButton);
        add(updateCustomerButton);

//        // Fetch customer action
//        fetchCustomerButton.addActionListener(e -> fetchCustomerInfo());
//
//        // Update customer action
//        updateCustomerButton.addActionListener(e -> updateCustomerInfo());
    }

    // Fetch customer info (just an example of fetching customer data)
//    private void fetchCustomerInfo() {
//        Client customer = ClientController.getId(1);  // Example: Fetch customer by ID
//        nameField.setText(customer.getName());
//        emailField.setText(customer.getEmail());
//        phoneField.setText(customer.getPhone());
//    }
//
//    // Update customer info
//    private void updateCustomerInfo() {
//        String name = nameField.getText();
//        String email = emailField.getText();
//        String phone = phoneField.getText();
//
//        Client client = new Client(name, address, email, phone);
//        client.setName(name);
//        client.setEmail(email);
//        client.setPhone(phone);
//
//        customerController.updateCustomer(customer);
//    }
}
