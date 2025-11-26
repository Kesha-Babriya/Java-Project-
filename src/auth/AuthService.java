package auth;

import model.Customer;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class AuthService {

    private static final String FILE_PATH = "src/data/users.csv";

    // ✅ Read all customers
    private static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    customers.add(new Customer(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // ✅ Validate login
    public static String validateUser(String username, String password) {
        for (Customer c : getAllCustomers()) {
            if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                return c.getRole();
            }
        }
        return null;
    }

    // ✅ Register new customer or admin
    public static boolean registerUser(String username, String password, String role) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
            return false;
        }

        if (userExists(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists!");
            return false;
        }

        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(username + "," + password + "," + role + "\n");
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving user data!");
            e.printStackTrace();
            return false;
        }
    }

    private static boolean userExists(String username) {
        for (Customer c : getAllCustomers()) {
            if (c.getUsername().equals(username)) return true;
        }
        return false;
    }
}
