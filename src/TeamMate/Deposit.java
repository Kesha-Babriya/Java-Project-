// Deposit.java
package TeamMate;
import javax.swing.*;
import java.awt.event.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amountField;
    JButton depositBtn;

    public Deposit() {
        setTitle("DEPOSIT MONEY");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("Enter amount:");
        label.setBounds(30, 30, 100, 30);
        add(label);

        amountField = new JTextField();
        amountField.setBounds(130, 30, 100, 30);
        add(amountField);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(90, 80, 100, 30);
        depositBtn.addActionListener(this);
        add(depositBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            Account.balance += amount;
            Account.log("Deposited", amount);
            JOptionPane.showMessageDialog(this, "Deposited ₹" + amount);
            dispose(); // Close the window
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount");
        }
    }
}
