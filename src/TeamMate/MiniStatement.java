// MiniStatement.java
package TeamMate;
import javax.swing.*;

public class MiniStatement extends JFrame {
    JTextArea statementArea;

    public MiniStatement() {
        setTitle("Mini Statement");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        statementArea = new JTextArea();
        statementArea.setBounds(20, 20, 350, 200);
        statementArea.setText(Account.getStatement());
        statementArea.setEditable(false);
        add(statementArea);

        setVisible(true);
    }
}
