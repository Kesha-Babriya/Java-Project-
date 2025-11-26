package ui;

import controller.BankController;
import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {
    private BankController bank;
    private String username;

    public CustomerDashboard(BankController bank, String username) {
        this.bank = bank;
        this.username = username;

        setTitle("Customer Dashboard - " + username);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome, " + username + "!", SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
