package TeamMate;
// package customerProfileManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class UpdateCustomer extends JFrame implements ActionListener {

    JTextField idT, nameT, emailT, contactT, addressT, cityT, pinT, stateT;
    JDateChooser dobT;
    JRadioButton male, female;
    JButton searchBtn, updateBtn, backBtn;

    public UpdateCustomer() {
        setTitle("Update Customer");
        setLayout(null);
        setSize(600, 700);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Update Customer Details");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setBounds(140, 20, 400, 40);
        add(heading);

        JLabel id = new JLabel("Customer ID:");
        id.setBounds(60, 80, 120, 25);
        add(id);

        idT = new JTextField();
        idT.setBounds(200, 80, 200, 25);
        add(idT);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(420, 80, 100, 25);
        searchBtn.addActionListener(this);
        add(searchBtn);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(60, 130, 120, 25);
        add(name);

        nameT = new JTextField();
        nameT.setBounds(200, 130, 250, 25);
        add(nameT);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(60, 180, 120, 25);
        add(dob);

        dobT = new JDateChooser();
        dobT.setBounds(200, 180, 250, 25);
        add(dobT);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(60, 230, 120, 25);
        add(gender);

        male = new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 230, 80, 25);
        add(male);

        female = new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(300, 230, 80, 25);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel email = new JLabel("Email:");
        email.setBounds(60, 280, 120, 25);
        add(email);

        emailT = new JTextField();
        emailT.setBounds(200, 280, 250, 25);
        add(emailT);

        JLabel contact = new JLabel("Contact No:");
        contact.setBounds(60, 330, 120, 25);
        add(contact);

        contactT = new JTextField();
        contactT.setBounds(200, 330, 250, 25);
        add(contactT);

        JLabel address = new JLabel("Address:");
        address.setBounds(60, 380, 120, 25);
        add(address);

        addressT = new JTextField();
        addressT.setBounds(200, 380, 250, 25);
        add(addressT);

        JLabel city = new JLabel("City:");
        city.setBounds(60, 430, 120, 25);
        add(city);

        cityT = new JTextField();
        cityT.setBounds(200, 430, 250, 25);
        add(cityT);

        JLabel pin = new JLabel("Pin Code:");
        pin.setBounds(60, 480, 120, 25);
        add(pin);

        pinT = new JTextField();
        pinT.setBounds(200, 480, 250, 25);
        add(pinT);

        JLabel state = new JLabel("State:");
        state.setBounds(60, 530, 120, 25);
        add(state);

        stateT = new JTextField();
        stateT.setBounds(200, 530, 250, 25);
        add(stateT);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(120, 580, 120, 30);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(280, 580, 120, 30);
        backBtn.addActionListener(this);
        add(backBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == searchBtn) {
            String id = idT.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter Customer ID!");
                return;
            }

            CustomerClass c = CustomerData.getCustomerById(id);
            if (c == null) {
                JOptionPane.showMessageDialog(null, "Customer not found!");
                return;
            }

            // Fill fields
            nameT.setText(c.getName());
            ((JTextField) dobT.getDateEditor().getUiComponent()).setText(c.getDob());
            if (c.getGender().equalsIgnoreCase("Male")) male.setSelected(true);
            else female.setSelected(true);
            emailT.setText(c.getEmail());
            contactT.setText(c.getContactNo());
            addressT.setText(c.getAddress());
            cityT.setText(c.getCity());
            pinT.setText(c.getPinCode());
            stateT.setText(c.getState());
        }

        else if (ae.getSource() == updateBtn) {
            String id = idT.getText().trim();
            String name = nameT.getText().trim();
            String dob = ((JTextField) dobT.getDateEditor().getUiComponent()).getText().trim();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");
            String email = emailT.getText().trim();
            String contact = contactT.getText().trim();
            String addr = addressT.getText().trim();
            String city = cityT.getText().trim();
            String pin = pinT.getText().trim();
            String state = stateT.getText().trim();

            // Validation
            if (id.isEmpty() || name.isEmpty() || dob.isEmpty() || gender.isEmpty() ||
                email.isEmpty() || contact.isEmpty() || addr.isEmpty() || city.isEmpty() ||
                pin.isEmpty() || state.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            }

            if (contact.length() != 10 || !contact.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Contact number must be exactly 10 digits!");
                return;
            }

            CustomerClass updated = new CustomerClass(id, name, dob, gender, email, contact, addr, city, pin, state);
            boolean success = CustomerData.updateCustomer(updated);

            if (success)
                JOptionPane.showMessageDialog(null, "Customer updated successfully!");
            else
                JOptionPane.showMessageDialog(null, "Customer not found!");
        }

        else if (ae.getSource() == backBtn) {
            setVisible(false);
            new CustomerProfileMenu();
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer();
    }
}
