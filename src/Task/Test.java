package Task;

public class Test {
	public static void main(String[] args) {
		ATMSystem atmSystem = new ATMSystem();
        ATM atm = new ATM(atmSystem);
        atm.start();
	}
}
