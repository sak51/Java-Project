import java.util.Scanner;

class BankAccount {

	String userID = "user123";
	String pin = "1234";
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your UserID - ");
		String UserID = sc.nextLine();
		System.out.print("\nEnter Your Pin - ");
		String Pin = sc.nextLine();
		if (UserID.equals(userID) && Pin.equals(pin)) {
			System.out.println("!!! You are login successfully. !!!");
			System.out.println("!! Welcome to ATM Interface. !!");
		} else {
			System.out.println("!! Sorry, Invalid UserID or Pin");
		}

	}

	public void withdraw() {
		System.out.println("\nEnter amount to withdraw :- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if (balance >= amount) {
			transactions++;
			balance -= amount;
			System.out.println("\nWithdraw Successfully");
			String str = amount + " Rs. Withdrawed\n";
			transactionHistory = transactionHistory.concat(str);

		} else {
			System.out.println("\nInsufficient Balance");
		}
		System.out.println("Your current balance :- " + balance);
	}

	public void deposit() {
		System.out.print("\nEnter amount to deposit :- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();

		if (amount <= 10000f) {
			transactions++;
			balance += amount;
			System.out.println("\nSuccessfully Deposited");
			String str = amount + " Rs. deposited\n";
			transactionHistory = transactionHistory.concat(str);
		} else {
			System.out.println("\nSorry...Limit is 100000.00");
		}
		System.out.println("Your current balance :- " + balance);
	}

	public void transfer() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Receipent's ID :- ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter amount to transfer - ");
		float amount = sc.nextFloat();

		if (balance >= amount) {
			if (amount <= 10000f) {
				transactions++;
				balance -= amount;
				System.out.println("\nSuccessfully Transfered to " + receipent);
				String str = amount + " Rs. transfered to " + receipent + "\n";
				transactionHistory = transactionHistory.concat(str);
			} else {
				System.out.println("\nInsufficient Balance");
			}
		}
		System.out.println("Your current balance :- " + balance);
	}

	public void transHistory() {
		if (transactions == 0) {
			System.out.println("\n Sorry...No Transaction History.");
		} else {
			System.out.println("\n" + transactionHistory);
		}
	}
}

class AtmInterface {

	public static void main(String[] args) {

		BankAccount b = new BankAccount();
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n**********WELCOME TO SBI ATM SYSTEM**********\n");
		b.login();
		do {
			System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Transaction History \n5.Quit");
			System.out.print("Enter Your Choice :- ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					b.withdraw();
					break;
				case 2:
					b.deposit();
					break;
				case 3:
					b.transfer();
					break;
				case 4:
					b.transHistory();
					break;
				case 5:
					System.out.println("...Quit...");
					System.out.println("Thank you to visit SBI ATM System");
			}
		} while (choice != 5);
	}
}
