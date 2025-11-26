package ui;

import controller.BankController;
import javax.swing.*;
import java.awt.*;
import TeamMate.*; // use their package where their classes live

/**
 * CombinedCustomerHub
 * Simple hub for customers to launch:
 * - Customer Profile Management (Anjal's code)
 * - Account Management (Twisha's BankGUI)
 * - Transaction Module (Moksha's MainFrameGUI / Transaction GUI)
 *
 * This class does not change teammates' code; it simply launches their frames.
 */
public class CombinedCustomerHub extends JFrame {
    private BankController bank;
    private String username;

    public CombinedCustomerHub(BankController bank, String username) {
        this.bank = bank;
        this.username = username;

        setTitle("Customer Hub - " + username);
        setSize(480, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel welcome = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 18));
        welcome.setBounds(80, 20, 320, 30);
        add(welcome);

        JButton profileBtn = new JButton("Customer Profile");
        profileBtn.setBounds(140, 70, 200, 40);
        add(profileBtn);

        JButton accountBtn = new JButton("Account Management");
        accountBtn.setBounds(140, 120, 200, 40);
        add(accountBtn);

        JButton transactionBtn = new JButton("Transactions");
        transactionBtn.setBounds(140, 170, 200, 40);
        add(transactionBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(180, 225, 120, 30);
        add(logoutBtn);

        // Button actions: just create the frames (their classes setVisible(true) in constructors)
        profileBtn.addActionListener(e -> {
            // Anjal's customer profile menu -> TeamMate.CustomerProfileMenu
            SwingUtilities.invokeLater(() -> {
                new TeamMate.CustomerProfileMenu();
            });
        });

        accountBtn.addActionListener(e -> {
            // Twisha's BankGUI
            SwingUtilities.invokeLater(() -> {
                new TeamMate.BankGUI();
            });
        });

        transactionBtn.addActionListener(e -> {
            // Moksha's MainFrameGUI (which opens TransactionGUI)
            SwingUtilities.invokeLater(() -> {
                new TeamMate.MainFrameGUI();
            });
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new auth.AuthApp(bank);
        });

        setVisible(true);
    }
}
