
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int passwordTries = 0;
        int password = 1234;
        int passwordInput;
        double balance = 2500.75;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("please enter your password");
            passwordInput = sc.nextInt();
            if (passwordInput != password) {
                passwordTries++;
                if (passwordTries != 3) {
                    System.out.println("wrong password please try again");
                } else {
                    System.out.println("Your account has been locked");
                }
            }
        } while (passwordInput != password && passwordTries < 3);


        if (passwordInput == password) {
            int withdrawTransactions = 0;
            int depositTransactions = 0;
            int userMenuInput = 0;

            userMenu:
            {
                while (true) {
                    System.out.println(" 1-Check Balance\n 2-Deposit\n 3-Withdraw\n 4-Show Account Status\n 5-Exit\n");
                    userMenuInput = sc.nextInt();
                    switch (userMenuInput) {
                        case 1:
                            System.out.println("The current balance is " + balance);
                            break;
                        case 2:
                            System.out.println("Please enter deposit amount");
                            double depositInput = sc.nextDouble();
                            if (depositInput < 0) {
                                System.out.println("Invalid amount");
                            } else if (depositInput == 0) {
                                System.out.println("transaction canceled");
                            } else {
                                balance += depositInput;
                                depositTransactions++;
                                System.out.println("New balance is " + balance);
                            }
                            break;
                        case 3:
                            System.out.println("Please enter withdraw amount");
                            double withdrawInput = sc.nextDouble();
                            if (withdrawInput < 0) {
                                System.out.println("Invalid amount");
                            } else if (withdrawInput == 0) {
                                System.out.println("transaction canceled");
                            } else {
                                if (balance >= withdrawInput) {
                                    balance -= withdrawInput;
                                    withdrawTransactions++;
                                    System.out.println("New balance is " + balance);
                                } else {
                                    System.out.println("Insufficient Balance");
                                }

                            }
                            if (balance == 0) {
                                System.out.println("Warning: your account is empty");
                            }
                            break;
                        case 4:
                            if (balance < 1000) {
                                System.out.println("low balance");
                            } else if (balance >= 1000 && balance < 5000) {
                                System.out.println("regular balance");
                            } else {
                                System.out.println("VIP customer");
                            }
                            break;
                        case 5:
                            if (depositTransactions > 0) {
                                System.out.println("successful deposit transactions :" + depositTransactions);
                            }
                            if (withdrawTransactions > 0) {
                                System.out.println("successful withdraw transactions :" + withdrawTransactions);
                            }
                            System.out.println("Thank you for using our ATM");
                            break userMenu;
                        default:
                            System.out.println("Invalid option");
                    }
                }
            }

        }
    }
}
