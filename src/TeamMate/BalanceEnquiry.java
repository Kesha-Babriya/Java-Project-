package TeamMate;
import javax.swing.*;

public class BalanceEnquiry extends JFrame {
    JLabel balanceLabel;
    JTextArea balanceArea;

    public BalanceEnquiry() {
        setTitle("Balance Enquiry");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        balanceArea = new JTextArea();
        balanceArea.setBounds(20, 30, 250, 100);
//        balanceArea.setText(Account.getBalance());
        balanceArea.setEditable(false);
        balanceLabel = new JLabel("Your Balance: ₹" + (Account.getBalance()));
        balanceLabel.setBounds(50, 70, 200, 30);
        add(balanceLabel);
        add(balanceArea);

        setVisible(true);
    }

}
