package TeamMate;
// package customerProfileManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ViewCustomers extends JFrame implements ActionListener {
    JTable table;
    JButton backBtn;

    public ViewCustomers() {
        setTitle("View Customers");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        System.out.println("Opening ViewCustomers...");
        List<CustomerClass> list = CustomerData.getAllCustomers();
        System.out.println("Found " + list.size() + " customers to display.");

        String[] columns = {"ID", "Name", "DOB", "Gender", "Email", "Contact", "Address", "City", "Pin", "State"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (CustomerClass c : list) {
            model.addRow(new Object[]{
                c.getId(), c.getName(), c.getDob(), c.getGender(), c.getEmail(),
                c.getContactNo(), c.getAddress(), c.getCity(), c.getPinCode(), c.getState()
            });
        }

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        add(backBtn, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new CustomerProfileMenu();
    }
}
