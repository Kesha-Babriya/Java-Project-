package auth;

import javax.swing.*;
import java.awt.*;
import controller.BankController;

public class RegisterForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleBox;
    private JButton registerButton, backButton;
    private BankController bank;

    public RegisterForm(BankController bankController) {
        this.bank = bankController;

        setTitle("Create New Account");
        setSize(420, 360);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Gradient background
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(255, 100, 100), 0, getHeight(), new Color(220, 50, 50));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bgPanel.setLayout(null);
        setContentPane(bgPanel);

        JLabel title = new JLabel("Register New User", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(90, 25, 240, 30);
        add(title);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setLayout(null);
        formPanel.setBounds(60, 80, 300, 200);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(formPanel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 20, 100, 25);
        formPanel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 20, 150, 25);
        formPanel.add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 65, 100, 25);
        formPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 65, 150, 25);
        formPanel.add(passwordField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(30, 110, 100, 25);
        formPanel.add(roleLabel);

        String[] roles = {"customer", "admin"};
        roleBox = new JComboBox<>(roles);
        roleBox.setBounds(120, 110, 150, 25);
        formPanel.add(roleBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(50, 160, 90, 30);
        registerButton.setBackground(new Color(0, 123, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        formPanel.add(registerButton);

        backButton = new JButton("Back");
        backButton.setBounds(160, 160, 90, 30);
        backButton.setBackground(new Color(230, 230, 230));
        backButton.setFocusPainted(false);
        formPanel.add(backButton);

        registerButton.addActionListener(e -> handleRegister());
        backButton.addActionListener(e -> {
            new AuthApp(bank);
            dispose();
        });

        setVisible(true);
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String role = roleBox.getSelectedItem().toString();

        boolean success = AuthService.registerUser(username, password, role);
        if (success) {
            JOptionPane.showMessageDialog(this, "User registered successfully!");
            new AuthApp(bank);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists or invalid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
