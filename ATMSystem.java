import java.util.Scanner;
class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount of  Rs " + amount + " has been added to your account.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public boolean deductFunds(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount of  Rs " + amount + " has been withdrawn from your account.");
            return true;
        } else {
            System.out.println("Error: Insufficient balance or invalid amount.");
            return false;
        }
    }
}
class ATM {
    private Account userAccount;
    private Scanner scanner;

    public ATM(Account account) {
        userAccount = account;
        scanner = new Scanner(System.in);
    }
    public void startATM() {
        int selection;
        do {
            System.out.println("\n--- ATM Operations ---");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (selection != 4);
    }

    private void showBalance() {
        System.out.printf("Your current balance is:  Rs %.2f%n", userAccount.getBalance());
    }

    private void performDeposit() {
        System.out.print("Enter the amount to deposit:  Rs ");
        double amount = scanner.nextDouble();
        userAccount.addFunds(amount);
    }

    private void performWithdrawal() {
        System.out.print("Enter the amount to withdraw:  Rs ");
        double amount = scanner.nextDouble();
        userAccount.deductFunds(amount);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Account myAccount = new Account(500);
        ATM myATM = new ATM(myAccount);
        myATM.startATM();
    }
}