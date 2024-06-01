package Task;

import java.util.Scanner;

public class ATM {
	private ATMSystem atmsys;
	
	public ATM (ATMSystem atmsys) {
		this.atmsys = atmsys;
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--------------------------------------");
		System.out.println("|         WELCOME TO THE ATM         |");
		System.out.println("--------------------------------------");
		System.out.println("Enter the User ID: ");
		String uid = sc.next();
		
		System.out.println("Enter the User Pin: ");
		String pin = sc.next();
		
	}
	
	private void showMenu(User user) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    user.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient user ID: ");
                    String recipientId = sc.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = sc.nextDouble();
                    user.transfer(recipientId, transferAmount, atmSystem);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
		
	}
	
}
	