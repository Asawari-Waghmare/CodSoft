// Task 3 (ATM Interface)
 import java.util.Scanner;

    class BankAccount {
        private double balance;
    
        public BankAccount(double initialBalance) {
            balance = initialBalance;
        }
    
        public double getBalance() {
            return balance;
        }
    
        public void depositAmount(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: RS " + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }
    
        public void withdrawAmount(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: RS " + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient balance.");
            }
        }
    }
    
    class ATM {
        private BankAccount bankAccount;
    
        public ATM(BankAccount account) {
            bankAccount = account;
        }
    
        public void checkBalance() {
            System.out.println("Current Balance: RS " + bankAccount.getBalance());
        }
    
        public void deposit(double amount) {
            bankAccount.depositAmount(amount);
        }
    
        public void withdraw(double amount) {
            bankAccount.withdrawAmount(amount);
        }
    }
    
    public class ATM_Interface {
        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000); // Initialize with an initial balance
            ATM atm = new ATM(account);
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
    
                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: RS ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: RS ");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Exiting...Visit Again...!!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
    
    
    
    
    
    
