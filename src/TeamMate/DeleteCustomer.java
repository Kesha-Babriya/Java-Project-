package TeamMate;
// package customerProfileManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener {

    JTextField idT;
    JButton deleteBtn, backBtn;

    public DeleteCustomer() {
        setTitle("Delete Customer");
        setSize(400, 250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Delete Customer");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(110, 20, 200, 30);
        add(heading);

        JLabel idLabel = new JLabel("Enter Customer ID:");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        idLabel.setBounds(40, 80, 150, 25);
        add(idLabel);

        idT = new JTextField();
        idT.setFont(new Font("Arial", Font.PLAIN, 15));
        idT.setBounds(190, 80, 150, 25);
        add(idT);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(60, 150, 100, 30);
        deleteBtn.setBackground(Color.RED);
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(220, 150, 100, 30);
        backBtn.setBackground(Color.GRAY);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteBtn) {
            String id = idT.getText().trim();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Customer ID.");
                return;
            }

            boolean success = CustomerData.deleteCustomer(id);

            if (success) {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully!");
                idT.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found!");
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new CustomerProfileMenu(); // go back to menu
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer();
    }
}
