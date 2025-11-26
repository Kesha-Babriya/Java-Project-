package TeamMate;
// package customerProfileManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerProfileMenu extends JFrame implements ActionListener {
    JButton addBtn, viewBtn, updateBtn, deleteBtn, searchBtn, exitBtn;

    public CustomerProfileMenu() {
        setTitle("Customer Profile Management");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 450);
        setLocationRelativeTo(null);

        JLabel heading = new JLabel("Customer Profile Management");
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBounds(80, 30, 400, 30);
        add(heading);

        addBtn = new JButton("Add Customer");
        addBtn.setBounds(150, 100, 200, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        viewBtn = new JButton("View Customers");
        viewBtn.setBounds(150, 150, 200, 30);
        viewBtn.addActionListener(this);
        add(viewBtn);

        updateBtn = new JButton("Update Customer");
        updateBtn.setBounds(150, 200, 200, 30);
        updateBtn.addActionListener(this);
        add(updateBtn);

        deleteBtn = new JButton("Delete Customer");
        deleteBtn.setBounds(150, 250, 200, 30);
        deleteBtn.addActionListener(this);
        add(deleteBtn);

        searchBtn = new JButton("Search Customer");
        searchBtn.setBounds(150, 300, 200, 30);
        searchBtn.addActionListener(this);
        add(searchBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(150, 350, 200, 30);
        exitBtn.addActionListener(this);
        add(exitBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == viewBtn) {
            setVisible(false);
            new ViewCustomers();
        } else if (ae.getSource() == updateBtn) {
            setVisible(false);
            new UpdateCustomer();
        } else if (ae.getSource() == deleteBtn) {
            setVisible(false);
            new DeleteCustomer();
        } else if (ae.getSource() == searchBtn) {
            setVisible(false);
            new SearchCustomer();
        } else if (ae.getSource() == exitBtn) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CustomerProfileMenu();
    }
}
