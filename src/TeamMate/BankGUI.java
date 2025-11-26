package TeamMate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class BankGUI extends JFrame {
    private ArrayList<AccountRecord> accounts;
    private JTable table;
    private DefaultTableModel model;
    private final String FILE_NAME = "accounts.dat";

    public BankGUI() {
        setTitle("Bank Account Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ====== Load Accounts ======
        accounts = loadAccounts();

        // ====== Top Buttons ======
        JPanel topPanel = new JPanel();
        JButton btnCreate = new JButton("Create Account");
        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnTransfer = new JButton("Transfer");
        JButton btnDelete = new JButton("Delete Account");
        JButton btnSaveExit = new JButton("Save & Exit");
        topPanel.add(btnCreate);
        topPanel.add(btnDeposit);
        topPanel.add(btnWithdraw);
        topPanel.add(btnTransfer);
        topPanel.add(btnDelete);
        topPanel.add(btnSaveExit);

        add(topPanel, BorderLayout.NORTH);

        // ====== Table ======
        model = new DefaultTableModel(new String[]{"Name", "Account No", "Balance"}, 0);
        table = new JTable(model);
        refreshTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // ====== Button Actions ======
        btnCreate.addActionListener(e -> createAccount());
        btnDeposit.addActionListener(e -> depositMoney());
        btnWithdraw.addActionListener(e -> withdrawMoney());
        btnTransfer.addActionListener(e -> transferMoney());
        btnDelete.addActionListener(e -> deleteAccount());
        btnSaveExit.addActionListener(e -> saveAndExit());

        setVisible(true);
    }

    private void createAccount() {
        JTextField nameField = new JTextField();
        JTextField accNoField = new JTextField();
        JTextField balField = new JTextField();

        Object[] msg = {"Name:", nameField, "Account No:", accNoField, "Initial Deposit:", balField};

        int opt = JOptionPane.showConfirmDialog(this, msg, "Create Account", JOptionPane.OK_CANCEL_OPTION);
        if (opt == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String accNo = accNoField.getText();
                double bal = Double.parseDouble(balField.getText());

                if (findAccount(accNo) != null) {
                    JOptionPane.showMessageDialog(this, "Account number already exists!");
                    return;
                }

                accounts.add(new AccountRecord(name, accNo, bal));
                refreshTable();
                saveAccounts();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        }
    }

    private void depositMoney() {
        String accNo = JOptionPane.showInputDialog(this, "Enter account number:");
        AccountRecord acc = findAccount(accNo);
        if (acc == null) {
            JOptionPane.showMessageDialog(this, "Account not found!");
            return;
        }
        String amtStr = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
        try {
            double amt = Double.parseDouble(amtStr);
            acc.deposit(amt);
            refreshTable();
            saveAccounts();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
        }
    }

    private void withdrawMoney() {
        String accNo = JOptionPane.showInputDialog(this, "Enter account number:");
        AccountRecord acc = findAccount(accNo);
        if (acc == null) {
            JOptionPane.showMessageDialog(this, "Account not found!");
            return;
        }
        String amtStr = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
        try {
            double amt = Double.parseDouble(amtStr);
            if (acc.withdraw(amt)) {
                refreshTable();
                saveAccounts();
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
        }
    }

    private void transferMoney() {
        String from = JOptionPane.showInputDialog(this, "Enter your account number:");
        AccountRecord accFrom = findAccount(from);
        if (accFrom == null) {
            JOptionPane.showMessageDialog(this, "Sender account not found!");
            return;
        }

        String to = JOptionPane.showInputDialog(this, "Enter receiver account number:");
        AccountRecord accTo = findAccount(to);
        if (accTo == null) {
            JOptionPane.showMessageDialog(this, "Receiver account not found!");
            return;
        }

        String amtStr = JOptionPane.showInputDialog(this, "Enter amount to transfer:");
        try {
            double amt = Double.parseDouble(amtStr);
            if (accFrom.transfer(accTo, amt)) {
                refreshTable();
                saveAccounts();
                JOptionPane.showMessageDialog(this, "Transfer successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient funds!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount!");
        }
    }

    private void deleteAccount() {
        String accNo = JOptionPane.showInputDialog(this, "Enter account number to delete:");
        AccountRecord acc = findAccount(accNo);
        if (acc != null) {
            accounts.remove(acc);
            refreshTable();
            saveAccounts();
            JOptionPane.showMessageDialog(this, "Account deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Account not found!");
        }
    }

    private void saveAndExit() {
        saveAccounts();
        JOptionPane.showMessageDialog(this, "All data saved. Goodbye!");
        System.exit(0);
    }

    // ===== Utility Methods =====
    private AccountRecord findAccount(String accNo) {
        for (AccountRecord acc : accounts)
            if (acc.getAccNo().equals(accNo)) return acc;
        return null;
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (AccountRecord acc : accounts) {
            model.addRow(new Object[]{acc.getName(), acc.getAccNo(), acc.getBalance()});
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<AccountRecord> loadAccounts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<AccountRecord>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data!");
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankGUI::new);
    }
}
