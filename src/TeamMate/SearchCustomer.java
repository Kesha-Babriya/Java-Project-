package TeamMate;
// package customerProfileManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SearchCustomer extends JFrame implements ActionListener {

    JTextField searchT;
    JButton searchBtn, backBtn;
    JTextArea resultArea;

    SearchCustomer() {
        setTitle("Search Customer");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(700, 500);
        setLocation(400, 150);

        JLabel heading = new JLabel("Search Customer Details");
        heading.setBounds(230, 20, 300, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);

        JLabel searchLbl = new JLabel("Enter ID or Name:");
        searchLbl.setBounds(100, 100, 200, 30);
        add(searchLbl);

        searchT = new JTextField();
        searchT.setBounds(260, 100, 200, 30);
        add(searchT);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(480, 100, 100, 30);
        searchBtn.addActionListener(this);
        add(searchBtn);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(resultArea);
        scroll.setBounds(100, 160, 500, 200);
        add(scroll);

        backBtn = new JButton("Back");
        backBtn.setBounds(300, 380, 100, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchBtn) {
            String query = searchT.getText().toLowerCase();
            ArrayList<CustomerClass> list = CustomerData.getAllCustomers();
            boolean found = false;
            resultArea.setText("");

            for (CustomerClass c : list) {
                if (c.getId().toLowerCase().equals(query) || c.getName().toLowerCase().contains(query)) {
                    resultArea.append(
                        "ID: " + c.getId() + "\n" +
                        "Name: " + c.getName() + "\n" +
                        "DOB: " + c.getDob() + "\n" +
                        "Gender: " + c.getGender() + "\n" +
                        "Email: " + c.getEmail() + "\n" +
                        "Contact: " + c.getContactNo() + "\n" +
                        "Address: " + c.getAddress() + "\n" +
                        "City: " + c.getCity() + "\n" +
                        "Pin: " + c.getPinCode() + "\n" +
                        "State: " + c.getState() + "\n\n"
                    );
                    found = true;
                }
            }

            if (!found) {
                resultArea.setText("No customer found!");
            }
        } 
        else if (ae.getSource() == backBtn) {
            setVisible(false);
            new CustomerProfileMenu();
        }
    }

    public static void main(String[] args) {
        new SearchCustomer();
    }
}