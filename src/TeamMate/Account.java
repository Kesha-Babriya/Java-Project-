// Account.java
package TeamMate;
public class Account {
    public static double balance = 10000; // Starting balance
    public static StringBuilder history = new StringBuilder();

    public static void log(String action, double amount) {
        String entry = action + ": " + amount + "Rupees" + "\n";
        history.append(entry);
    }

    public static String getStatement() {
        return "Balance: " + balance + "\n\nTransactions:\n Rupees" + history.toString();
    }

    public static double getBalance() {
        return balance;
    }
}
