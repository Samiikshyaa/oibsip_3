package Task;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String id;
	private String pin;
	private Account account;
	private List<Transaction> transactionHistory;
	
	public User(String id, String pin, Account account) {
		this.id = id;
		this.pin = pin;
		this.account = account;
		this.transactionHistory = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	
	public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Withdraw successful. Current balance: " + account.getBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful. Current balance: " + account.getBalance());
    }

    public void transfer(String recipientId, double amount, ATMSystem atmSystem) {
        User recipient = atmSystem.getUserById(recipientId);
        if (recipient != null) {
            if (account.withdraw(amount)) {
                recipient.account.deposit(amount);
                transactionHistory.add(new Transaction("Transfer to " + recipientId, amount));
                recipient.transactionHistory.add(new Transaction("Transfer from " + id, amount));
                System.out.println("Transfer successful. Current balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Recipient user not found.");
        }
    }
}

