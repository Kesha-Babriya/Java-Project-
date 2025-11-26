// Withdraw.java
package TeamMate;
import javax.swing.*;
import java.awt.event.*;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amountField;
    JButton withdrawBtn;

    public Withdrawal() {
        setTitle("Withdraw Money");
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

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(90, 80, 100, 30);
        withdrawBtn.addActionListener(this);
        add(withdrawBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= Account.balance) {
                Account.balance -= amount;
                Account.log("Withdrew", amount);
                JOptionPane.showMessageDialog(this, "Withdrew ₹" + amount);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount");
        }
    }
}
