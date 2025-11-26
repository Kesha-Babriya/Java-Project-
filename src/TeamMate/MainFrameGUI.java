package TeamMate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrameGUI extends JFrame implements ActionListener
{
    JButton transactionBtn;

   public MainFrameGUI()
    {
        setSize(1480, 1480);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("WELCOME TO BANK MANAGEMENT SYSTEM");
        title.setFont(new Font("Times New Roman", Font.BOLD, 32));
        title.setBounds(350, 30, 800, 70);
        add(title);

        transactionBtn = new JButton("TRANSACTION");
        transactionBtn.setBounds(550, 140, 260, 70);
        transactionBtn.setForeground(Color.WHITE);
        transactionBtn.setBackground(new Color(0, 0, 240));
        transactionBtn.setFont(new Font("Arial", Font.BOLD, 20));
        transactionBtn.addActionListener(this); // ✅ enable ActionListener
        add(transactionBtn);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == transactionBtn)
        {
            new TransactionGUI(); // make sure TransactionGUI exists
        }
    }

    public static void main(String args[])
    {
        new MainFrameGUI();
    }
}
