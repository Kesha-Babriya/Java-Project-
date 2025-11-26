package ui;

import controller.BankController;
import auth.AuthApp;

public class MainApp {
    public static void main(String[] args) {
        BankController bank = new BankController(); // ✅ create controller
        new AuthApp(bank); // ✅ open login page first
    }
}
