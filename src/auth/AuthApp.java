package auth;

import controller.BankController;
import ui.AdminDashboard;
import ui.CombinedCustomerHub; // <-- changed: open hub instead of CustomerDashboard

import javax.swing.*;
import java.awt.*;

public class AuthApp extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private BankController bank;

    public AuthApp(BankController bankController) {
        this.bank = bankController;
        setTitle(" Bank Login");
        setSize(420, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Background gradient panel
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(50, 150, 250), 0, getHeight(), new Color(0, 80, 200));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        JLabel title = new JLabel("Secure Bank Login", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(80, 30, 260, 30);
        add(title);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(60, 80, 300, 180);
        formPanel.setLayout(null);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(formPanel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 25);
        formPanel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(110, 20, 160, 25);
        usernameField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        formPanel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 65, 100, 25);
        formPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(110, 65, 160, 25);
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180)));
        formPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(40, 115, 100, 30);
        loginButton.setBackground(new Color(0, 123, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        formPanel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 115, 100, 30);
        registerButton.setBackground(new Color(230, 230, 230));
        registerButton.setFocusPainted(false);
        formPanel.add(registerButton);

        loginButton.addActionListener(e -> handleLogin());
        registerButton.addActionListener(e -> {
            new RegisterForm(bank);
            dispose();
        });

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        String role = AuthService.validateUser(username, password);
        if (role == null) {
            JOptionPane.showMessageDialog(this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Welcome " + username + " (" + role + ")", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();

        if (role.equalsIgnoreCase("admin")) {
            new AdminDashboard(bank).setVisible(true);
        } else {
            // OPEN THE HUB that integrates 3 teammate modules
            new CombinedCustomerHub(bank, username).setVisible(true);
        }
    }
}
