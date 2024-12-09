package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.example.Main;
import org.example.controller.PaymentController;
import org.example.controller.ShowTimeController;
import org.example.controller.BookingController;
import org.example.model.Booking;
import org.example.model.Payment;
import org.example.model.ShowTime;

public class PaymentView extends JFrame {
    private JTextField cardNumberField, expirationField, cvvField;
    private JLabel amountLabel;
    private JButton payButton;
    private double amount;  // Amount to be paid (this should be passed from BookingView or MovieView)

    public PaymentView(ShowTime newShowTime, double amount) {
        this.amount = amount;

        setTitle("Payment");
        setLayout(new FlowLayout());

        JLabel cardNumberLabel = new JLabel("Credit Card Number:");
        cardNumberField = new JTextField(16);

        JLabel expirationLabel = new JLabel("Expiration Date (MM/YY):");
        expirationField = new JTextField(5);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvField = new JTextField(3);

        amountLabel = new JLabel("Amount to Pay: $ " + amount);
        add(amountLabel);

        payButton = new JButton("Pay Now");

        add(cardNumberLabel);
        add(cardNumberField);
        add(expirationLabel);
        add(expirationField);
        add(cvvLabel);
        add(cvvField);
        add(amountLabel);
        add(payButton);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve credit card details
                String cardNumber = cardNumberField.getText();
                String expirationDate = expirationField.getText();
                String cvv = cvvField.getText();

                // Validate credit card details (this is a basic validation for the example)
                if (validateCardDetails(cardNumber, expirationDate, cvv)) {
                    // Get the user ID (assume logged-in user for now, hardcode or retrieve from login)
                    int userId = 1; // Placeholder, replace with actual user ID
                    Payment payment = new Payment(0, userId, amount);  // Payment object, 0 for new payment
                    PaymentController paymentController = new PaymentController();
                    paymentController.createPayment(payment);
                    ShowTimeController.addShowtime(newShowTime);
                    BookingController.createBooking(new Booking(Main.loggedClientId,newShowTime.getShowTimeId()));


                    // Show success message and navigate back to main view or previous screen
                    JOptionPane.showMessageDialog(PaymentView.this, "Payment Successful!");
                    new MainView().setVisible(true);  // Assuming the main view will be shown after payment
                    dispose();
                } else {
                    String invalidMessage = """
                            Invalid credit card details!
                            Card number must be 16 characters.
                            Card expiration date must be 4 characters.
                            Card cvv number must be 3 characters.
                            """;
                    JOptionPane.showMessageDialog(PaymentView.this, invalidMessage);
                }
            }
        });

        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private boolean validateCardDetails(String cardNumber, String expirationDate, String cvv) {
        // Basic validation of credit card details
        if (cardNumber.length() != 16 || expirationDate.length() != 4 || cvv.length() != 3) {
            return false;  // Return false if the details don't meet the expected format
        }

        // Additional logic can be added for further validation (e.g., check card number format, expiration date, etc.)
        return true;
    }
}