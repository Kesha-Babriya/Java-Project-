// FastCash.java
package TeamMate;
import javax.swing.*;
import java.awt.event.*;

public class FastCash extends JFrame implements ActionListener {
    JButton b500, b1000, b2000;

    public FastCash() {
        setTitle("Fast Cash");
        setSize(300, 250);
        setLayout(null);
        setLocationRelativeTo(null);

        b500 = new JButton("₹500");
        b500.setBounds(90, 30, 100, 30);
        b500.addActionListener(this);
        add(b500);

        b1000 = new JButton("₹1000");
        b1000.setBounds(90, 80, 100, 30);
        b1000.addActionListener(this);
        add(b1000);

        b2000 = new JButton("₹2000");
        b2000.setBounds(90, 130, 100, 30);
        b2000.addActionListener(this);
        add(b2000);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int amount = 0;
        if (e.getSource() == b500) amount = 500;
        else if (e.getSource() == b1000) amount = 1000;
        else if (e.getSource() == b2000) amount = 2000;

        if (Account.balance >= amount) {
            Account.balance -= amount;
            Account.log("Fast Cash", amount);
            JOptionPane.showMessageDialog(this, "Withdrawn ₹" + amount);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Insufficient Balance");
        }
    }
}
