package TeamMate;
//package customerProfileManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.UUID;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {

    JTextField idT, nameT, emailT, contactNoT, addressT, cityT, pinCodeT, stateT;
    JRadioButton male, female;
    JDateChooser dobT;
    JButton addBtn, backBtn;

    Signup() {
        setTitle("Add Customer");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Add New Customer");
        heading.setFont(new Font("Raleway", Font.BOLD, 24));
        heading.setBounds(180, 20, 400, 30);
        add(heading);

        // Auto ID
        String customerId = UUID.randomUUID().toString().substring(0, 8);
        JLabel id = new JLabel("Customer ID:");
        id.setBounds(100, 70, 150, 30);
        add(id);
        idT = new JTextField(customerId);
        idT.setBounds(250, 70, 200, 30);
        idT.setEditable(false);
        add(idT);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 120, 150, 30);
        add(name);
        nameT = new JTextField();
        nameT.setBounds(250, 120, 200, 30);
        add(nameT);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 170, 150, 30);
        add(dob);
        dobT = new JDateChooser();
        dobT.setBounds(250, 170, 200, 30);
        add(dobT);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 220, 150, 30);
        add(gender);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        male.setBounds(250, 220, 80, 30);
        female.setBounds(340, 220, 100, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        add(male);
        add(female);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 270, 150, 30);
        add(email);
        emailT = new JTextField();
        emailT.setBounds(250, 270, 200, 30);
        add(emailT);

        JLabel contact = new JLabel("Contact No:");
        contact.setBounds(100, 320, 150, 30);
        add(contact);
        contactNoT = new JTextField();
        contactNoT.setBounds(250, 320, 200, 30);
        add(contactNoT);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 370, 150, 30);
        add(address);
        addressT = new JTextField();
        addressT.setBounds(250, 370, 200, 30);
        add(addressT);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 420, 150, 30);
        add(city);
        cityT = new JTextField();
        cityT.setBounds(250, 420, 200, 30);
        add(cityT);

        JLabel pin = new JLabel("Pin Code:");
        pin.setBounds(100, 470, 150, 30);
        add(pin);
        pinCodeT = new JTextField();
        pinCodeT.setBounds(250, 470, 200, 30);
        add(pinCodeT);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 520, 150, 30);
        add(state);
        stateT = new JTextField();
        stateT.setBounds(250, 520, 200, 30);
        add(stateT);

        addBtn = new JButton("Add");
        addBtn.setBounds(150, 580, 100, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(300, 580, 100, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(600, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addBtn) {

            // ===== Validation =====
            if (nameT.getText().trim().isEmpty() || emailT.getText().trim().isEmpty() ||
                contactNoT.getText().trim().isEmpty() || addressT.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill all mandatory fields!");
                return;
            }

            String contact = contactNoT.getText().trim();
            if (!contact.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(null, "Contact number must be exactly 10 digits!");
                return;
            }

            String email = emailT.getText().trim();
            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
                return;
            }

            if (((JTextField) dobT.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select Date of Birth!");
                return;
            }

            // ===== Save to CSV =====
            String id = idT.getText();
            String name = nameT.getText();
            String dob = ((JTextField) dobT.getDateEditor().getUiComponent()).getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String addr = addressT.getText();
            String city = cityT.getText();
            String pin = pinCodeT.getText();
            String state = stateT.getText();

            CustomerData.addCustomer(new CustomerClass(id, name, dob, gender, email, contact, addr, city, pin, state));
            JOptionPane.showMessageDialog(null, "Customer Added Successfully!");
            setVisible(false);
            new CustomerProfileMenu();
        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new CustomerProfileMenu();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}