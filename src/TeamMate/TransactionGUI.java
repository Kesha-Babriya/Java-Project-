// Bank.java
package TeamMate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionGUI extends JFrame implements ActionListener
{
    JButton depositBtn, withdrawBtn, fastCashBtn, miniStatementBtn, balanceEnquiryBtn, pinChangeBtn, exitBtn;

    public TransactionGUI() {
        setTitle("BANK TRANSACTION");
        setSize(1480, 1480);
        setLayout(null);
        setLocationRelativeTo(null);
    //    setDefaultCloseOperation(EXIT_ON_CLOSE);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel title = new JLabel("TRANSACTIONS");
        title.setFont(new Font("Times New Roman", Font.BOLD, 32));
        title.setBounds(550, 20, 450, 50);
        add(title);

        depositBtn = new JButton("CASH DEPOSIT");
        depositBtn.setBounds(180, 140, 260, 70);
        depositBtn.setForeground(Color.WHITE);
        depositBtn.setBackground(new Color(30,40,125));
        depositBtn.setFont(new Font("Arial", Font.BOLD, 18));
        depositBtn.addActionListener(this);
        add(depositBtn);

        withdrawBtn = new JButton("CASH WITHDRAWAL");
        withdrawBtn.setBounds(180, 290, 260, 70);
        withdrawBtn.setForeground(Color.WHITE);
        withdrawBtn.setBackground(new Color(30,40,125));
        withdrawBtn.setFont(new Font("Arial", Font.BOLD, 18));
        withdrawBtn.addActionListener(this);
        add(withdrawBtn);

        fastCashBtn = new JButton("FAST CASH");
        fastCashBtn.setBounds(180, 430, 260, 70);
        fastCashBtn.setForeground(Color.WHITE);
        fastCashBtn.setBackground(new Color(30,40,125));
        fastCashBtn.setFont(new Font("Arial", Font.BOLD, 18));
        fastCashBtn.addActionListener(this);
        add(fastCashBtn);

        miniStatementBtn = new JButton("MINI STATEMENT");
        miniStatementBtn.setBounds(880, 134, 260, 70);
        miniStatementBtn.setForeground(Color.WHITE);
        miniStatementBtn.setBackground(new Color(30,40,125));
        miniStatementBtn.setFont(new Font("Arial", Font.BOLD, 18));
        miniStatementBtn.addActionListener(this);
        add(miniStatementBtn);

        balanceEnquiryBtn = new JButton("CHECK BALANCE");
        balanceEnquiryBtn.setBounds(880, 285, 260, 70);
        balanceEnquiryBtn.setForeground(Color.WHITE);
        balanceEnquiryBtn.setBackground(new Color(30,40,125));
        balanceEnquiryBtn.setFont(new Font("Arial", Font.BOLD,18));
        balanceEnquiryBtn.addActionListener(this);
        add(balanceEnquiryBtn);


        exitBtn = new JButton("EXIT");
        exitBtn.setBounds(880, 430, 260, 70);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBackground(new Color(30,40,125));
        exitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        exitBtn.addActionListener(this);
        add(exitBtn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositBtn)
        {
            new Deposit();
        }
        else if (e.getSource() == withdrawBtn)
        {
            new Withdrawal();
        }
        else if (e.getSource() == miniStatementBtn)
        {
            new MiniStatement();
        }
        else if (e.getSource() == fastCashBtn)
        {
            new FastCash();
        }
        else if(e.getSource() == balanceEnquiryBtn)
        {
                new BalanceEnquiry();
        }

        else if (e.getSource() == exitBtn) {
     //       System.exit(0);
dispose();

        }

    }

    public static void main(String[] args) {
       TransactionGUI transactionGUI = new TransactionGUI(); // Launch main menu
    }
}
