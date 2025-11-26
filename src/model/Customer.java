package model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String accountNumber;
    private double balance;
    private boolean approved;
    private String accountType;
    private LocalDate createdDate;

    // 🔹 Auth info
    private String username;
    private String password;
    private String role; // "admin" or "customer"

    // Main constructor (for Admin Dashboard use)
    public Customer(String name, String accountNumber, double balance, boolean approved, String accountType) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.approved = approved;
        this.accountType = accountType;
        this.createdDate = LocalDate.now();
    }

    // Constructor for Auth
    public Customer(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdDate = LocalDate.now();
    }

    // Getters
    public String getName() { return name; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public boolean isApproved() { return approved; }
    public String getAccountType() { return accountType; }
    public LocalDate getCreatedDate() { return createdDate; }

    // 🔹 Auth getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setApproved(boolean approved) { this.approved = approved; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    // 🔹 Auth setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }

    // Display info
    public void displayInfo() {
        System.out.println("Customer: " + name + " | Acc#: " + accountNumber + " | Balance: " + balance);
    }

    // ---------------- CSV Support ----------------
    public String toCSV() {
        // Format: name,accountNumber,balance,approved,accountType
        return name + "," + accountNumber + "," + balance + "," + approved + "," + accountType;
    }

    public static Customer fromCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) return null; // invalid line
        String name = parts[0];
        String acc = parts[1];
        double balance = Double.parseDouble(parts[2]);
        boolean approved = Boolean.parseBoolean(parts[3]);
        String type = parts[4];
        return new Customer(name, acc, balance, approved, type);
    }
}