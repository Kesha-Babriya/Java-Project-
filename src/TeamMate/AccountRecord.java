package TeamMate;

import java.io.Serializable;

public class AccountRecord implements Serializable {
    private String name;
    private String accNo;
    private double balance;

    public AccountRecord(String name, String accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    // No-arg constructor (in case some serialization/deserialize needs it)
    public AccountRecord() {
        this.name = "";
        this.accNo = "";
        this.balance = 0.0;
    }

    public String getName() { return name; }
    public String getAccNo() { return accNo; }
    public double getBalance() { return balance; }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            return true;
        }
        return false;
    }

    public boolean transfer(AccountRecord target, double amt) {
        if (target == null) return false;
        if (amt > 0 && amt <= balance) {
            this.balance -= amt;
            target.balance += amt;
            return true;
        }
        return false;
    }
}
